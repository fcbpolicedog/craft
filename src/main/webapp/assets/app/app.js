var App = function () {

    var _masterCheckbox;
    var _checkbox;

    var _idArray;
    //私有方法，初始化ICheck
    var handlerInitCheckbox = function () {
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        });

        _masterCheckbox = $('input[type="checkbox"].minimal.icheck_master');
        _checkbox = $('input[type="checkbox"].minimal');
    };
    //checkbox全选
    var handlerCheckboxAll = function () {
        _masterCheckbox.on("ifClicked",function (e) {
            //console.log(e.target.checked);
            //返回true，表示未选中
            if (e.target.checked) {
                _checkbox.iCheck("uncheck");
            }
            //选中状态
            else {
                _checkbox.iCheck("check");
            }
        });
    };

    var handlerDeleteMulti = function (url) {
        _idArray = new Array();

        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if(_id != null && _id != "undefine" && $(this).is(":checked")){
                _idArray.push(_id);
            }
        });

        if (_idArray.length === 0){
            $("#modal-message").html("还未选择任何数据，请至少选择一项");
        }
        else {
            $("#modal-message").html("确定删除所选数据项吗？");
        }

        $("#modal-default").modal("show");

        $("#btnModalOK").bind("click",function () {
            del();
        });

        function del() {
            $("#modal-default").modal("hide");
            if (_idArray.length === 0){
                //......
            }
            else {
                setTimeout(function () {
                    $.ajax({
                        "url":url,
                        "type":"POST",
                        "data":{"ids":_idArray.toString()},
                        "dataType":"JSON",
                        "success":function (data) {
                            //删除成功
                            if (data.status===200){
                                window.location.reload();
                            }else {
                                $("#btnModalOK").unbind("click");
                                $("#btnModalOK").bind("click",function () {
                                    $("#modal-default").modal("hide");
                                });
                                $("#modal-message").html(data.message);
                                $("#modal-default").modal("show");

                            }
                        }
                    });
                },500);
            }
        }
    };

    return{
        init:function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },

        getCheckbox:function () {
            return _checkbox;
        },
        deleteMulti:function (url) {
            console.log("test");
            handlerDeleteMulti(url);
        }
    }
}();

$(document).ready(function () {
    App.init();
});