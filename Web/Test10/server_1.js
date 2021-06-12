/**
 * node.js 入门
 */

// 1.引入 HTTP 模块
let http = require('http');

// 2.准备处理请求和响应的 service 函数
function service(request, response) {
    response.writeHead(200, {'Content-Type':'text/plain'});
    response.end('Hello Node');
}

// 3.基于service函数来创建服务器
let server = http.createServer(service);

// 4. 服务器监听于8088端口
server.listen(8088);