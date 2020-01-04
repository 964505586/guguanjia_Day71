let vm = new Vue({
    el:'#main-container',
    data:{
        pageInfo:{
            pageNum: 1,
            pageSize: 5,
        }
    },
    methods:{
        selectAll: function (pageNum, pageSize) {
        },
        download:function () {
            // 下载区域信息数据
            location.href='manager/area/download';
        },
        upload:function (event) {
            // 获取事件源   上传input
            let formDate = new FormData();  // 构建表单对象
            // 绑定文件到upFile  upFile需要与后台接收方法参数MultipartFile的名字对应
            formDate.append("upFiles", event.target.files[0]);
            // 提交信息
            axios({
                url:'manager/area/upload',
                method:'post',
                data:formDate,
                headers:{   // 设置请求头
                    'Content-Type' : 'Multipart/form-data'  // 设置请求题格式
                }
            }).then(response => {
                layer.msg(response.data.msg)
            }).catch(error => {
                layer.msg(error)
            })
        }
    }
});