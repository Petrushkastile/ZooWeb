
function selectZoo(jsonData) {
    $.ajax({
        type: "POST",
        url: "/getTypes",
        data: jsonData,
        dataType:'json',
        async: true,
        success: function(item) {
            switch (item["answer"]) {
                case "types":
                    var types = item["types"].replace("[", "").replace("]", "").split(",");
                    alert(types)
                    var x = document.getElementById("selectTypes");

                    if (types) {
                        var i;
                        for (i = 0; i < types.length; i++) {
                            var type = new Option(types[i]);
                            x.options.add(type);
                        }
                    }
                    break;
                case "names":
                    var names = item["names"].replace("[", "").replace("]", "").split(",");
                    alert(names)
                    var y = document.getElementById("selectZoos");
                    if (names) {
                        var i;
                        for (i = 0; i < names.length; i++) {
                            var name = new Option(names[i]);
                            y.options.add(name);
                        }
                    }
                    break;
            }
      },
    error: function (xhr, status, error) {
        alert(error);
    }
});
}
function getTypes()
{
    var jsonData = new Object();
    jsonData.command = "0";

    selectZoo(JSON.stringify(jsonData));
}
function getZoo()
{
    var jsonData = new Object();
    jsonData.command = "1";

    selectZoo(JSON.stringify(jsonData));
}
