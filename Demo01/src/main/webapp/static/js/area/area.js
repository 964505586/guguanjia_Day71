let vm = new Vue({
    el:'#main-container',
    data: function() {
        return{
            pageInfo:{
                pageNum: 1,
                pageSize: 5,
                areaName: '',
                aid:1
            },
            // params:{
            //     pageNum: '',
            //     pageSize: '',
            //     areaName: '',
            //     aid:1
            // },
            settings:{
                data:{
                    simpleData:{
                        enable:true,
                        pIdKey:'parentId'
                    }
                },
                callback:{
                    onClick: this.onClick
                }
            },
            nodes:[],
            treeObj:{}
        }

    },
    methods:{
        selectAll: function (pageNum, pageSize) {
            this.pageInfo.pageNum = pageNum;
            this.pageInfo.pageSize = pageSize;
            axios({
                url:'manager/area/index',
                method: 'post',
                data: this.pageInfo
            }).then(response => {
                this.pageInfo = response.data();
            }).catch(error => {
                layer.msg(error)
            })

        },
        download:function () {
            // 下载区域信息数据
            location.href='manager/area/download';
        },
        upload:function (event) {
            // 获取事件源   上传input
            let formDate = new FormData();  // 构建表单对象
            // 绑定文件到upFile  upFile需要与后台接收方法参数MultipartFile的名字对应
            formDate.append("upFile", event.target.files[0]);
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
        },
        onClick:function () {


        },
        toUpdate:function (id) {
            axios({
                url:'manager/area/toUpdate',
                params:{areaId: id}
            }).then(response => {
                layer.obj = response.data;
                let op = layer.open({
                    type:'2',
                    title:'区域修改 ',
                    content:'area/save',
                    area:['80%', '80%'],
                    end:() => {     // 将then函数中的this传递到end的回调函数中
                        this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
                    }
                })

            }).catch(error => {
                layer.msg(error)
            })
        }
    }
});