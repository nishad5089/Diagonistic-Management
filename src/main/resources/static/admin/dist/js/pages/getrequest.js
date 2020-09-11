GET: $(document).ready(
    function() {

        // GET REQUEST
        $("#getALlBooks").click(function(event) {
            event.preventDefault();
            ajaxGet();
        });

        // DO GET
        function ajaxGet() {
            $.ajax({
                type : "GET",
                contentType : "application/json",
                url : "getBooks",
                cache: false,
                success : function(result) {
                    console.log(result);
                    $.each(result,
                        function(i, book) {
                           alert(book.bookName)
                        });
                },
                error : function(e) {
                    alert(e)
                }
            });
        }
    })