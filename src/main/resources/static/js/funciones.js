function invitacionesEnviadas() {
        window.alert("Invitaciones Enviadas")
    }

$(document).ready(function () {
    var startTable = "table1";
    var $tabs = $("#" + startTable);
    $("tbody.connectedSortable")
        .sortable({
        connectWith: ".connectedSortable",
        items: "> tr:not(:first)",
        appendTo: $tabs,
        helper: "clone",
        cursor: "move",
        zIndex: 999990,
        start: function (event, ui) {
            //alert("start1");
            var start_pos = ui.item.index();
            ui.item.data('start_pos', start_pos);
        }
    });

    var startTable2 = "table2";
    var $tabs2 = $("#" + startTable2);
    $("tbody.connectedSortable")
        .sortable({
        connectWith: ".connectedSortable",
        items: "> tr:not(:first)",
        appendTo: $tabs,
        helper: "clone",
        cursor: "move",
        zIndex: 999990,
        start: function (event, ui) {
            //alert("start2");
            var start_pos = ui.item.index();
            ui.item.data('start_pos', start_pos);
            //alert(start_pos);
        },
        update: function (event, ui) {
          if (this.id == 'table2' && this === ui.item.parent()[0] )
             alert($item);
          else if (this.id == 'table1' && this === ui.item.parent()[0] )
             alert("update1");
        }
    });

});