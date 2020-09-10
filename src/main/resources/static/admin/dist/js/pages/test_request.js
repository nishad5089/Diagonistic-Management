$(document).ready(function(){
    $("#input1").change(function(event){
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
            timeout: 600000,
            success: function (data) {
                $("#fee").val(data);
            },
            error: function (e) {

            alert("Failed")

            }
        });
    });
        $("#submitbtn").click(function(event){

        //stop submit the form event. Do this manually using ajax post function
        event.preventDefault();
        var patName = $("#patName").val();

        var testRequestTest={
            "testRequest": {
                "nameOfPatient": patName,
                "dateOfBirth": $("#dob").val(),
                "mobileNO": $("#mobileNo").val()
            },
            "test" : {
                "id" : $("#input1").val()
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
            timeout: 600000,
            success: function (data) {

               // var markup = "<tr><td><input type='checkbox' name='record'></td><td>" + name + "</td><td>" + email + "</td></tr>";

                // $.each(data, function(i, test){
                //     var tests = "{Id: " + test.id +
                //         ", Name: " + test.testName +
                //         ", Fee: " + test.fee +"}";
                //
                //   alert(tests);
                // });

                var obj = JSON.parse(data);
                var len = data.length;
                alert("length"+len)
               alert(obj.id)
                alert(data)
            },
            error: function (e) {
                alert("Failed")
            }
        });
    });


});
