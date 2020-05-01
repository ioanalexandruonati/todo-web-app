//Sorts the "Priority" column of the table based on the level of priority.

function sort() {
    var todoType, customKey1, customeKey2, customeKey3;

    todoType = document.getElementById("priority");

    if (todoType === "High") {
        customKey1 === 1;
    } else if (todoType === "Medium") {
        customKey1 === 2;
    } else if (todoType === "Low") {
        customKey1 === 3;
    }
}

// Searches in the table based on the input given, by the text available in the column "Description".

function myFunction() {
    // Declare variables
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[1];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

//Changes the color of the cell in "Priority" column, based on the value present in it.

var allTableCells = document.getElementsByTagName("td");
for (var i = 0, max = allTableCells.length; i < max; i++) {
    var node = allTableCells[i];

    //get the text from the first child node - which should be a text node
    var currentText = node.childNodes[0].nodeValue;

    //check for 'one' and assign this table cell's background color accordingly
    if (currentText === "High")
        node.style.backgroundColor = "red";
    else if (currentText == "Medium")
        node.style.backgroundColor = "orange";
    else if (currentText == "Low")
        node.style.backgroundColor == "lemonchiffon";
}

//Date picker/calendar (https://github.com/yui/yui3/blob/master/LICENSE.md):

YUI().use('calendar', 'datatype-date', 'cssbutton', function (Y) {

    // Create a new instance of calendar, placing it in
    // #mycalendar container, setting its width to 340px,
    // the flags for showing previous and next month's
    // dates in available empty cells to true, and setting
    // the date to today's date.
    var calendar = new Y.Calendar({
        contentBox: "#mycalendar",
        width: '340px',
        showPrevMonth: true,
        showNextMonth: true,
        date: new Date()
    }).render();

    // Get a reference to Y.DataType.Date
    var dtdate = Y.DataType.Date;

    // Listen to calendar's selectionChange event.
    calendar.on("selectionChange", function (ev) {

        // Get the date from the list of selected
        // dates returned with the event (since only
        // single selection is enabled by default,
        // we expect there to be only one date)
        var newDate = ev.newSelection[0];

        // Format the date and output it to a DOM
        // element.
        Y.one("#selecteddate").setHTML(dtdate.format(newDate));
    });
});