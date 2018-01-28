function Add() {
    var type = document.getElementById("selectTypes").value;

    if (type=="Monkey"){
        $('#box')[0].reset();
        o.src='/images/Monkey.png';
        document.getElementById('box').appendChild(o);
         }
    if (type=="Dog"){
        $('#box')[0].reset();
        o.src='/images/Dog.png';
        document.getElementById('box').appendChild(o)
    }
    if (type=="Cat"){
        $('#box')[0].reset();
        o.src='/images/Cat.png';
        document.getElementById('box').appendChild(o);
    }
    if (type=="Tiger"){
        $('#box')[0].reset();
        o.src='/images/Tiger.png';
        document.getElementById('box').appendChild(o)
    }
}
