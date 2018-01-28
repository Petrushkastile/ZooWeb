
function addName() {
    var name = document.getElementById("newNameZooInput").value;
    var nameZoo = {"nameZoo": name};
    var url = "/addName";
    $.ajax({
        url: url,
        method: "post",
        data: nameZoo,
        error: function (message) {
            console.log(message);
        },
        success: function (data) {
            console.log(data);
        }
    });
}