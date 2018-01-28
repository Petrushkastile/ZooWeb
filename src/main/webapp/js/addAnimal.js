function addAnimal() {
    var name = document.getElementById("INPUT NAME").value;
    var age  = document.getElementById("INPUT AGE").value;
    var zooName = document.getElementById("selectZoos").value;
    var type = document.getElementById("selectTypes").value;
    var Animal = {"name": name, "age":age, "zooName":zooName, "type":type };

    $.ajax({
        url: "/addAnimal",
        method: 'POST',
        dataType: 'json',
        contentType: "charset=UTF-8",
        data: JSON.stringify(Animal),

        error: function (message) {
            console.log(message);
        },
        success: function (data) {
            document.getElementById("result").innerText = data.result;
        }
    });
}