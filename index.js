// 事件绑定，在 window 上发生 load 事件时，执行该方法
// window.load 事件，代表整个 html 和 js 内容全部被浏览器加载完成了
window.onload = function () {
    // 通过 xhr 直接获取后端的数据
    // /api/list-surveys.json
    let xhr = new this.XMLHttpRequest();
    xhr.open("get", "/api/list-surveys.json");  // 向 /api/list-surveys.json 发起 get 请求

    // 事件绑定，在 xhr 发生 load 事件时，执行对应的方法
    // xhr 的 load 事件发生，代表请求成功了
    xhr.onload = function () {
        if (xhr.status != 200) {
            // HTTP 响应的状态码不是 200
            return;
        }

        let response = JSON.parse(xhr.response);
        if (response.status != 200) {
            // HTTP 正文中的 JSON，我们定义 API 格式中的 status 不是 200
            return;
        }

        console.log(response.data);
        let data = response.data;
        // 找到 html 内容，id 是 survey-list 的 ol 标签
        let olElement = document.querySelector("ol#survey-list");
        for (let i = 0; i < data.length; i++) {
            let title = data[i].title;
            let liElement = document.createElement("li");
            liElement.innerText = title;

            olElement.appendChild(liElement);
        }
    };
    xhr.send(); // 真正发起请求
};