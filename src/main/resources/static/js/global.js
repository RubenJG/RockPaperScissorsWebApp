//
// Main javascript script for the Rock Paper Scissors Web Application
//
// Author: Rubén Jiménez Goñi

// Binding to document ready
$( document ).ready(init);

/**
 * Function that gets called when the document is ready
 */
function init() {
    // When on the home page, bind form events
    $('#fileUploadForm').submit(fileUploadFormSubmitHandler);
    $('#directEntryForm').submit(directEntryFormSubmitHandler);
}

// ============================================================================
// = Home page ================================================================
// ============================================================================

var strategies = {
    'R': 'Rock',
    'P': 'Paper',
    'S': 'Scissors'
};

/**
 * This method handles the way the submit event is handled when
 * the file upload form is used
 */
function fileUploadFormSubmitHandler(event) {
    disableForms(event);
    // HTML5 FileReader
    var reader = new FileReader();
    reader.onload = function(e) {
        sendData(reader.result);    
    }
    reader.readAsText($('#championshipFile')[0].files[0]);
}

/**
 * This method handles the way the submit event is handled when 
 * the direct entry form is used
 */
function directEntryFormSubmitHandler(event) {
    disableForms(event);
    sendData($('#directEntryForm textarea').val());
}

/**
 * This method prevents the default submit behaviour
 * and disables both forms in the home page
 */
function disableForms(event) {
    // Disable default behavior
    event.preventDefault();
    // Disable both forms
    $('form :input').prop('disabled', true);
    // Clear winner text
    $('p.winner').text('');
}

function sendData(data) {
    data = data.replace(/\s+/g, '');
    $.ajax({
        url: '/api/championship/new',
        data: 'data='+data,
        method: 'POST'
    }).done(done).fail(fail);
}

function done(result) {
    removeDivClasses();
    setWinnerText('The winner is ' + result.winner[0] + ' with ' + strategies[result.winner[1]], 'alert-success');
    enableForms();
}

function fail() {
    removeDivClasses();
    setWinnerText('There seems to be a problem with your championship file. Please try again!', 'alert-danger');
    enableForms();
}

function enableForms() {
    // Enable both forms
    $('form :input').prop('disabled', false);
}

function removeDivClasses() {
    $('.winner').removeClass('hidden')
    $('div.winner').removeClass('alert-success').removeClass('alert-danger');
}

function setWinnerText(text, className) {
    $('div.winner').addClass(className);
    $('p.winner').text(text);
} 

// ============================================================================
// = Test methods =============================================================
// ============================================================================

function testApiChampionshipResult() {
    $.ajax({
        url: '/api/championship/result',
        data: 'first=Dave&second=Armando',
        method: 'POST'
    }).done(function(e){
        console.log(e)
    }).fail(function(e) {
        console.log('Test failed');
    });
}

function testApiChampionshipTop() {
    $.ajax({
        url: '/api/championship/top',
        data: 'count=5',
        method: 'POST'
    }).done(function(e){
        console.log(e)
    }).fail(function(e) {
        console.log('Test failed');
    });
    $.ajax({
        url: '/api/championship/top',
        method: 'POST'
    }).done(function(e){
        console.log(e)
    }).fail(function(e) {
        console.log('Test failed');
    });
}




