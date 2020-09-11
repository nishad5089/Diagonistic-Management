$(document).ready(
    function() {

        // SUBMIT FORM
        $("#bookForm").submit(function(event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPost();
        });

        function ajaxPost() {

            // PREPARE FORM DATA
            var formData = {
                bookId : $("#bookId").val(),
                bookName : $("#bookName").val(),
                author : $("#author").val()
            }

            // DO POST
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "saveBook",
                data : JSON.stringify(formData),
                dataType : 'json',
                cache: false,
                success : function(result) {
                    alert(result.bookName);
                    console.log(result);
                },
                error : function(e) {
                    alert(e);
                }
            });

        }

    })