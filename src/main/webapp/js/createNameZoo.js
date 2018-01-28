
function addName() {
    var name = document.getElementById("newNameZooInput").value;
    var nameZoo = {"nameZoo": name};

    alert("новое имя зоопарка "+name+" передано")
    $.ajax({
        url: "/addName",
        method: 'POST',
        dataType: 'json',
        contentType: "charset=UTF-8",
        data: JSON.stringify(nameZoo),

        error: function (message) {
            console.log(message);
        },
        success: function (data) {
            document.getElementById("result").innerText = data.result;
           }
    });
}
