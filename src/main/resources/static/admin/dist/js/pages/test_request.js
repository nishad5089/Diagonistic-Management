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
                $("#fee").val(data.fee);
            },
            error: function (e) {

                alert("Failed")

            }
        });
    });
    $("#form").submit(function (event) {
        event.preventDefault();
        var patName = $("#patName").val();

        var testRequestTest = {
            "testRequest": {
                "nameOfPatient": patName,
                "dateOfBirth": $("#dob").val(),
                "mobileNO": $("#mobileNo").val()
            },
            "test": {
                "id": $("#input1").val()
            }
        }
        // $("#btn-login").prop("disabled", true);

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/admin/testrequest",
            data: JSON.stringify(testRequestTest),
            dataType: 'json',
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
                    if (!(confirm('Are you sure you want to delete this employee?'))) return false
                    // $("table tbody").find('input[name="record"]').each(function(){
                    //     if($(this).is(":checked")){
                    //
                    //     }
                    // });
                    $(this).parents("tr").remove();

                });


            },
            error: function (e) {
                alert("Failed")
            }
        });
    });


});
