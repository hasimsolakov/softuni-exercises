if (!Modernizr.inputtypes.date) {
    $(function () {
        var item = $(".datepicker");
        $.fn.datepicker.defaults.format = "dd-MM-yyyy";
        item.datepicker();
        
    });
}
$(".datepicker").on("blur", function(e) {
     $(this).off("focus").datepicker("hide");
});