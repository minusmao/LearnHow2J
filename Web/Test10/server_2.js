/**
 * node.js 获取参数
 */

// 1.引入相关模块
let http = require('http');    // HTTP 模块
let url = require('url');      // URL 模块
let querystring = require('querystring');    // 引入 querystring 库，也是帮助解析用的

// 2.准备处理请求和响应的 service 函数
function service(request, response) {
    //获取返回的url对象的query属性值
    let arg = url.parse(request.url).query;
     
    //将arg参数字符串反序列化为一个对象
    let params = querystring.parse(arg);
     
    //请求的方式
    console.log("method: " + request.method);
     
    //请求的url
    console.log("url: " + request.url);
 
    //获取参数id
    console.log("id: " + params.id);
 
    response.writeHead(200, {'Content-Type': 'text/plain'});
    response.end('Hello Node.js');
}

// 3.基于service函数来创建服务器
let server = http.createServer(service);

// 4. 服务器监听于8088端口
server.listen(8088);