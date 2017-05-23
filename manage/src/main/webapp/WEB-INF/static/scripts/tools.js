var formatTime = function(longTime) {
    //转化为 日+小时+分+秒
    var time = parseFloat(longTime);
    if (time != null && time != ""){
        if (time < 60) {
            var s = time;
            time = s;
        } else if (time > 60 && time < 3600) {
            var m = parseInt(time / 60);
            var s = parseInt(time % 60);
            time = (m<10?"0"+m:m) + ":" + (s<10?"0"+s:s);
        } else if (time >= 3600) {
            var h = parseInt(time / 3600);
            var m = parseInt(time % 3600 / 60);
            var s = parseInt(time % 3600 % 60 % 60);
            time = (h<10?"0"+h:h) + ":" + (m<10?"0"+m:m) + ":" + (s<10?"0"+s:s);
        }
    }   
    return time;    
}

Date.prototype.format = function(format)
{
   var o = {
   "M+" : this.getMonth()+1, //month
   "d+" : this.getDate(),    //day
   "h+" : this.getHours(),   //hour
   "m+" : this.getMinutes(), //minute
   "s+" : this.getSeconds(), //second
   "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
   "S" : this.getMilliseconds() //millisecond
   }
   if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
   (this.getFullYear()+"").substr(4 - RegExp.$1.length));
   for(var k in o)if(new RegExp("("+ k +")").test(format))
   format = format.replace(RegExp.$1,
   RegExp.$1.length==1 ? o[k] :
   ("00"+ o[k]).substr((""+ o[k]).length));
   return format;
}

Date.prototype.format2 = function(format)
{
    var o = {
        "m+" : this.getMonth()+1, //month
        "d+" : this.getDate(),    //day
        "h+" : this.getHours(),   //hour
        "i+" : this.getMinutes(), //minute
        "s+" : this.getSeconds(), //second
        "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
        "S" : this.getMilliseconds() //millisecond
    }
    if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
        (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)if(new RegExp("("+ k +")").test(format))
        format = format.replace(RegExp.$1,
            RegExp.$1.length==1 ? o[k] :
                ("00"+ o[k]).substr((""+ o[k]).length));
    return format;
}

String.prototype.toInt = function(def) {
    def = def || 0;
    try{
        var v = parseInt(this);
        if (isNaN(v)) {
            return def;
        }
        return v;
    } catch (ex){
    }
    return def;
}

String.prototype.replaceAll = function(s1, s2) {
    return this.replace(new RegExp(s1, "gm"), s2);
}

/**
 * 扩展数组删除指定位置元素
 * @param {} index 被删除元素下标
 * @return {}
 */
Array.prototype.delIndex = function(index) {
    if (index < 0) return this;
    return this.slice(0, index).concat(this.slice(index+1, this.length));
}

/**
 * 扩展数组删除指定元素
 * @param {} data 要被删除的元素
 * @return {}
 */
Array.prototype.delData = function(data) {
    if (!data) return this;
    var index = -1;
    for (var i = 0; i < this.length; i++) {
        if (data === this[i]) {
            index = i;
            break;
        }
    }
    return this.delIndex(index);
}

/**
 * 数组对象中指定属性，生成新的数组
 * @param {} data
 * @return {}
 */
Array.prototype.findArray = function(data) {
    if (!data) return this;
    var arr = [];
    for (var i = 0; i < this.length; i++) {
        arr.push(this[i][data]);
    }
    return arr;
}

String.prototype.changeStayName = function(){
    if (this.substring(0,1) == ">") {
        return "驻留" + this.substring(1) + "分钟以上";
    } else if (this.indexOf("-") >= 0) {
        return "驻留" + this + "分钟";
    }
    return this;
}
var initCustomDate=function(cont, _opt){
    var option = {
        language : 'zh-CN',
        format : "yyyy-mm-dd",
        autoclose : true,
        startView : 2,
        minView : 2,
        maxView : 2,
        viewSelect : 2
    };
    _opt = _opt || {};
    $.extend(option, _opt);
    cont = cont || "body";
    $(".custom-date", cont).each(function(){
        $this = $(this);
        $this.datetimepicker(option).on('changeDate', function(ev){
            var next = $(this).data("next");
            if (next == null || $(next, cont).length == 0) {
                return;
            }
            var sd = ev.date;
            $(next, cont).datetimepicker("setStartDate", Common.dateAddDayStr(0, "-", sd));
            $(next, cont).val(Common.dateAddDayStr(0, "-", sd));
            $(next+"_v", cont).val(Common.dateAddDayStr(0, "-", sd));
        });
    });
}