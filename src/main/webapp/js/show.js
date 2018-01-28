function show() {
    var name = document.getElementById("selectZoos").value;
    var nameZoo = {"showZoo": name};
    $.ajax({
        url: "/showZoo",
        method: 'POST',
        dataType: 'json',
        contentType: "charset=UTF-8",
        data: JSON.stringify(nameZoo),
        success: function (item) {
            var a = item["animals"].replace("[", "").replace("]", "").split(",");
            var y = document.getElementById("seeanimals");
            if (a) {
                var i;
                for (i = 0; i < a.length; i++) {
                    var animal = new Option(a[i]);
                    y.options.add(animal);
                }
            }
        },
        error: function (xhr, status, error) {
            alert(error);
        }
    });
}