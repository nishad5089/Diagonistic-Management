var total =0;
$(document).ready(function () {
    $("#input1").change(function (event) {
        var id = $(this).val();

        //stop submit the form event. Do this manually using ajax post function
        event.preventDefault();

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/admin/testfee",
            data: JSON.stringify(id),
            dataType: 'json',
            cache: false,
            success: function (data) {
                $("#fee").val(data);
            },
            error: function (e) {

                alert("Failed")

            }
        });
    });
    $("#form").submit(function (event) {
        event.preventDefault();
        // var patName = $("#patName").val();
        var id= $("#input1").val()

        $(".delete-row").click(function(){
            if (!(confirm('Are you sure you want to delete this employee?'))) return false
            $(this).parents("tr").remove();
        });
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/admin/gettest?id="+id,
            cache: false,
            success: function (data) {
                var markup = "<tr><td>1.</td><td>" + data.testName + "</td><td>" + data.fee + "</td>  <td>\n" +
                    "<a th:href=\"www.google.com\"\n" +
                    "class=\"btn btn-info btn-sm\" style='color: #fff'>\n" +
                    "Edit\n" +
                    "</a>\n" +
                    "\n" +
                    "<a th:href=\"#\"\n" +
                    "class=\"btn btn-danger btn-sm delete-row\" style='color: #fff'>\n" +
                    "Delete\n" +
                    "</a>\n" +
                    "</td></tr>";
                $("table tbody").append(markup);
                $(".delete-row").click(function(){
                    // if (!(confirm('Are you sure you want to delete this employee?'))) return false
                    $(this).parents("tr").remove();
                });

                    total += data.fee;
                $("#total").val(total);


            },
            error: function (e) {
                alert("Failed")
            }
        });
    });

    $("#save").click(function (event) {
        event.preventDefault();

        var testRequest = {
                "nameOfPatient": $("#patName").val(),
                "dateOfBirth": $("#dob").val(),
                "mobileNO": $("#mobileNo").val(),
                "amount": $("#total").val()
            };

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/admin/testrequest",
            data: JSON.stringify(testRequest),
            dataType: 'json',
            cache: false,
            success: function (data) {
             $("#patName").val("");
             $("#dob").val("");
             $("#mobileNo").val("");
             $("#total").val(0);
             $('#input1').val('selectedIndex',0);
             $('#fee').val("");


                console.log("Success")
            },
            error: function (e) {
             console.log(e)
            }
        });
    });
});
