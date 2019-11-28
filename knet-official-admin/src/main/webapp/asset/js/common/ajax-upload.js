function upladFile(f, callback) {
    var FileController = "/upload"; // 接收上传文件的后台地址
    // FormData 对象
    var form = new FormData();
    //form.append("author", "hooyes"); // 可以增加表单数据
    form.append("file", f); // 文件对象
    // XMLHttpRequest 对象
    var xhr = new XMLHttpRequest();
    xhr.open("post", FileController, true);
    xhr.onload = function () {
        callback($.parseJSON(xhr.responseText))
    };
    xhr.send(form);
}