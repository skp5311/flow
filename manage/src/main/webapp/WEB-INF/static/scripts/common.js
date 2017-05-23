 /***************************************************************
 *         -----------------------------------------
 *                        通用工具功能
 *         -----------------------------------------
 **************************************************************/
//var ctx = $("#ctx").val();
//var shopId = $("#shopId").val();
//var userLevel = $("#userLevel").val();
//var nickName = $("#nickName").val();
var Common = (function(me) {
	/**
	 * 初始化
	 */
	me.init = function() {
		toastr.options = {
			"closeButton": false,
			"debug": false,
			"newestOnTop": false,
			"progressBar": false,
			"positionClass": "toast-top-full-width",
			"preventDuplicates": true,
			"onclick": null,
			"showDuration": "300",
			"hideDuration": "1000",
			"timeOut": "2000",
			"extendedTimeOut": "1000",
			"showEasing": "swing",
			"hideEasing": "linear",
			"showMethod": "fadeIn",
			"hideMethod": "fadeOut"
		}
	}

	/**
	 * 初始化Metronic框架所需信息 页面JS调用，common库不要主动调用
	 */
	me.initMetronic = function() {
		if (typeof(Metronic) != "undefined") {
			Metronic.init();
			//Metronic.setAssetsPath(ctx + "/assets/");
		}
		if (typeof(Layout) != "undefined") {
			Layout.init();
		}
		if (typeof(Demo) != "undefined") {
			Demo.init();
		}
	}

	/**
	 * 提示消息功能，支持鼠标悬停
	 * 主要有4类：msg/info、success、warning、error
	 */
	me.msg = function(msg, title) {
		toastr.info(msg, title);
	}
	me.info = function(msg, title) {
		me.msg(msg, title);
	}
	me.success = function(msg, title) {
		toastr.success(msg, title);
	}
	me.warning = function(msg, title) {
		toastr.warning(msg, title);
	}
	me.error = function(msg, title) {
		toastr.error(msg, title);
	}
	me.showMsg = function(msg, type, title) {
		toastr.options.positionClass = "toast-top-full-width";
		toastr.options.timeOut = "2000";
		if (!type) {
			me.msg(msg, title);
		} else {
			me[type](msg, title);
		}
	}

	/**
	 * 安全注销
	 */
	me.logout = function() {
		layer.confirm('您确认要退出系统吗？', {icon: 3, title:'温馨提示', moveType: 1}, function(index){
			window.location.replace(ctx + "/user/logout.do");
			layer.close(index);
		});
	}


	/**
	 * 通用方法，显示弹出窗口
	 * 支持配置的项目：
	 * @param type         窗体类型 可传入的值有：1（页面层，默认）2（iframe层）3（加载层）4（tips层），除0不需要设置，其他都需要设置
	 * @param dataType  自定义区别标示，非layer配置项，0为jQuery对象，1为HTML字符串，默认为0; 注意如果加载的是HTML，dataType必须设置为1
	 * @param content*   弹出框显示内容，这里为默认为jQuery对象；也可以是HTML代码，或者URL(type需要设置为2-iframe)
	 * @param title          窗口标题 类型：String/Array/Boolean，自定义标题区域样式title: ['文本', 'font-size:18px;']；title: false不显示标题
	 * @param maxmin    是否支持最大、最小化，默认支持，false关闭此功能
	 * @param area         弹出窗口显示大小 默认['1000px', '500px']
	 * @param closeBtn   关闭按钮样式：1(title区域内部右侧)和2(title区域右上角突出显示，默认值)
	 * @param shift         窗口显示效果 支持值0~6(默认值0)，基于CSS3效果，不支持IE6~9
	 * @param success    窗口初始化完毕后回调函数
	 * @param end         销毁窗口时回调函数
	 */
	me.showDialog = function(config) {
	  	if (!config.dataType || config.dataType == 0) {
	  		config.content.removeClass("hide");
	  	}
	  	me.loading();
	  	layerIndex = layer.open({
			type: config.type == null ? 1 : config.type,
	  		skin: 'layui-layer-lan',
	  		title: config.title == null ? false : config.title,
	  		// fix: false,	//滚动时是否跟随窗口一起，默认为true
	  		// shade: [0.8, '#393D49'],  //此配置项可以不写，默认为0.3
	  		shift: config.shift == null ? 0 : config.shift,	// 支持值0~6(默认值0)，基于CSS3效果，不支持IE6~9  2(从下显示) 3(从左显示闪出) 4(从左顺时针旋转出现) 5(fadein) 6(左右震动出现)
	  		moveType: 1,	// 拖拽风格，支持0(拖拽时显示透明边框)、1两个值(不显示边框)，默认为0
	  		scrollbar: false,	//是否显示浏览器出现滚动条，默认值为true，false可以禁止浏览器页面滚动，效果不错（这里有个Bug，最大化然后还原后，窗口滚动条又显示出来了）
	  		shadeClose: false,
	  		moveOut: true,
	  		maxmin: config.maxmin == null ? true : config.maxmin,
	  		area: config.area == null ? ['1000px', '550px'] : config.area,
	  		content: config.content,
	  		closeBtn: config.closeBtn == null ? 2 : config.closeBtn,
	  		success: function(dom, index) {
	  			layer.closeAll('loading');
	  			if (config.success) {config.success(dom, index);}
	  		},
	  		end: function(){	//销毁时调用方法
	  			if (config.end) {config.end();}
	  			me.operateOverflow("auto");
	  		},
	  		restore: function() {
	  			me.operateOverflow("hidden");	//自己新增代码，解决最大化然后还原后，窗口滚动条又显示出来的BUG
	  		}
	  	});
	  	if (config.full) {
	  		layer.full(layerIndex);
	  	}
	}

	/**
	 * 加载扩展模块，例如要使用弹出用户填写内容输入框layer.prompt()则需要加载
	 */
	me.loadExtend = function() {
		layer.config({
			extend: 'extend/layer.ext.js'
		});
	}

	me.loading = function(type) {
		type = type == null ? 0 : type;
		var index = layer.load(type, {shadeClose: false, shade: [0.1, '#393D49']});
		return index;
	}

	me.loaded = function(index) {
		if (index) {
		 	layer.close(index);
		} else {
		 	layer.closeAll('loading');
		}
	}


	/**
	 * Ajax异步请求数据
	 * @param url
	 * @param callback
	 * @param param
	 * @param errcallback 发生错误的回调函数
	 * @param type
	 * @param dataType    默认格式为JSON
	 * @param async
	 */
	me.simpleAjax = function(url, callback, param, errcallback, type, dataType, async){
		$.ajax({
			url: url,
			data: param,
			type: type == null ? 'get' : type,
			dataType: dataType == null ? 'json' : dataType,
			async: async == null ? true : async,
			timeout: 5*60000,
			success: function(xhr, status) {
				if (status != 'success') {
					me.error('Ajax responsed but is not success，服务器返回结果:' + xhr);
					return;
				}
				if (callback) {callback(xhr)}
			},
			error: function(xhr, status) {
				if (errcallback) {errcallback(xhr);}
			},
			complete: function(xhr, status) {
				me.loaded(xhr.getResponseHeader("mdata_loadIndex"));
				//通过XMLHttpRequest取得响应头，sessionstatus，
				var sessionstatus=xhr.getResponseHeader("sessionstatus");
				if(sessionstatus=="timeout" && window.loginTimeout == null){
					window.loginTimeout = true;
					layer.confirm('登录超时,请重新登录！', {
						closeBtn: 0,
						btn: ['确定'] //按钮
					}, function(){
						window.location.replace(options.nologin || "/");
					});
				}
			},
			beforeSend: function(xhr) {
				var loadIndex = me.loading();
				xhr.setRequestHeader("mdata_loadIndex", loadIndex);
			}
		});
	}

	/**
	 * Ajax异步加载HTML页面
	 * @param url
	 * @param callback
	 * @param param
	 * @param errcallback 发生错误的回调函数
	 * @param type
	 * @param async
	 */
	me.doAjaxHtml = function(url, callback, param, errcallback, type, async) {
		$.ajax({
			url: url,
			data: param,
			async: async == null ? true : async,
			type: type == null ? 'get' : type,
			dataType: 'html',
			timeout: 60000,
			success: function(xhr, status) {
				if (status != 'success') {
					me.error('Ajax Success function，服务器返回结果:' + xhr);
					return;
				}
				if (callback) {callback(xhr);}
			},
			error: function(xhr, status) {
				me.error('Ajax Error function，服务器返回结果:' + xhr);
				if (errcallback) {errcallback(xhr);}
			},
			complete: function(xhr, status) {
				me.loaded(xhr.getResponseHeader("mdata_loadIndex"));
				//通过XMLHttpRequest取得响应头，sessionstatus，
				var sessionstatus=xhr.getResponseHeader("sessionstatus");
				if(sessionstatus=="timeout" && window.loginTimeout == null){
					window.loginTimeout = true;
					layer.confirm('登录超时,请重新登录！', {
						closeBtn: 0,
						btn: ['确定'] //按钮
					}, function(){
						window.location.replace(options.nologin || "/");
					});
				}
			},
			beforeSend: function(xhr) {
				var loadIndex = me.loading();
				xhr.setRequestHeader("mdata_loadIndex", loadIndex);
			}
		});
	}

	/**
	 * Ajax异步请求数据
	 * @param url
	 * @param options
	 */
	me.doAjax = function(url, options, ajaxData) {
		options = options || {};
		if (ajaxData != null) {
			ajaxData.times = ajaxData.times || 0;
			ajaxData.times ++ ;
		}
		options = $.extend({
			type : 'post',
			params : {},
			dataType : 'json',
			async : true,
			loginurl : '/login',
			timeout : 5 * 60000,
		}, options);
		$.ajax({
			url: url,
			data: options.params,
			type: options.type,
			dataType: options.dataType,
			async: options.async,
			timeout: options.timeout,
			success: function(xhr, status) {
				if (status != 'success') {
					me.error('Ajax responsed but is not success，服务器返回结果:' + xhr);
					return;
				}
				if (options.callback) {options.callback(xhr)}
			},
			error: function(xhr, status) {
				me.error('Ajax Error function，服务器返回结果:' + xhr);
				if (options.errcallback) {options.errcallback(xhr);}
			},
			complete: function(xhr, status) {
				if (ajaxData != null) {
					ajaxData.times -- ;
				}
				me.loaded(xhr.getResponseHeader("mdata_loadIndex"));
				//通过XMLHttpRequest取得响应头，sessionstatus，
				var sessionstatus=xhr.getResponseHeader("sessionstatus");
				if(sessionstatus=="timeout" && window.loginTimeout == null){
					window.loginTimeout = true;
					layer.confirm('登录超时,请重新登录！', {
						closeBtn: 0,
						btn: ['确定'] //按钮
					}, function(){
						window.location.replace(options.nologin || "/");
					});
					//alert("登录超时,请重新登录！");
					////如果超时就处理 ，指定要跳转的页面
					//window.location.replace(options.nologin || "/");
				}
				if (options.comcallback) {options.comcallback(xhr);}
			},
			beforeSend: function(xhr) {
				var loadIndex = me.loading();
				xhr.setRequestHeader("mdata_loadIndex", loadIndex);
				//layer.load(0, {shadeClose: false, shade: [0.8, '#393D49']});
			}
		});
	}

	/**
	 * 模拟表单提交下载数据
	 */
	me.download = function(url, params, method) {
		if (url && params) {
			var inputs = '';
			for (var key in params) {
				var value = params[key];
				if (value && value.indexOf("{") != -1) {
					inputs += '<input type="hidden" name="' + key + '" value=\'' + params[key] + '\' />';
				} else {
					inputs += '<input type="hidden" name="' + key + '" value="' + params[key] + '" />';
				}
			}
			$('<form action="' + url + '" method="' + (method || 'post') + '">' + inputs + '</form>')
				.appendTo('body').submit().remove();
		};
	};

	/**
	 * 计算两个数的最大公约数
	 */
	me.divisor = function(m, n) {
		var mod = m % n;
		if (mod == 0) {
			return n;
		} else {
			return me.divisor(n, mod);
		}
	}

	/**
	 * 计算百分比，指定四舍五入
	 * @param numerator 分子
	 * @param denominator 分母
	 * @param decimal 保留几位小数
	 */
	me.percent = function(numerator, denominator, decimal) {
		if (!denominator || denominator == 0) {
			return 0;
		}
		return (numerator/denominator*100).toFixed(decimal);
	}

	/**
	 * 生成一个m以内的随机正整数，含0不含m
	 */
	me.random = function(m) {
		return Math.floor(Math.random() * m);
	}

	/**
	 * 日期比较
	 * @param {} date1
	 * @param {} date2
	 * @return {}
	 */
	me.dateCompare = function(date1, date2) {
		if (date2 == null) {
			date2 = new Date();
		}
		return date1.getTime() - date2.getTime();
	}

	/**
	 * 根据给定的偏移天数格式化日期格式
	 * @param {} offset 偏移天数 正数日期向后，负数日期向前
	 * @param {} separator	日期中的分隔符
	 * @param {} date	基础日期
	 * @return {}
	 */
	me.dateAddDay = function(offset, date) {
		var tempDate;
		if (date) {
			tempDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() + offset);
		} else {
			tempDate = new Date();
			tempDate.setDate(tempDate.getDate() + offset);
		}
		return tempDate;
	}

	/**
	 * 根据给定的偏移天数格式化日期格式
	 * @param {} offset 偏移天数 正数日期向后，负数日期向前
	 * @param {} separator	日期中的分隔符
	 * @param {} date	基础日期
	 * @return {}
	 */
	me.dateAddDayStr = function(offset, separator, date) {
		var tempDate;
		if (date) {
			tempDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() + offset);
		} else {
			tempDate = new Date();
			tempDate.setDate(tempDate.getDate() + offset);
		}
		var tempSeparator = separator == null ? "" : separator;
		return tempDate.getFullYear() + tempSeparator + ((tempDate.getMonth() + 1) >= 10 ? (tempDate.getMonth() + 1) : "0" + (tempDate.getMonth() + 1)) + tempSeparator + (tempDate.getDate() >= 10 ? tempDate.getDate() : "0" + tempDate.getDate());
	}

	/**
	 * 根据给定的偏移月数格式化日期格式
	 * @param {} offset 偏移月数 正数日期向后，负数日期向前
	 * @param {} separator	日期中的分隔符
	 * @param {} date	基础日期
	 * @return {}
	 */
	me.dateAddMonthStr = function(offset, separator, date) {
		var tempDate;
		if (date) {
			tempDate = new Date(date.getFullYear(), date.getMonth() + offset, date.getDate());
		} else {
			tempDate = new Date();
			tempDate.setMonth(tempDate.getMonth() + offset);
		}
		var tempSeparator = separator == null ? "" : separator;
		return tempDate.getFullYear() + tempSeparator + ((tempDate.getMonth() + 1) >= 10 ? (tempDate.getMonth() + 1) : "0" + (tempDate.getMonth() + 1)) + tempSeparator + (tempDate.getDate() >= 10 ? tempDate.getDate() : "0" + tempDate.getDate());
	}

	/**
	 * 根据给定的偏移月数格式化日期格式
	 * @param {} offset 偏移月数 正数日期向后，负数日期向前
	 * @param {} date	基础日期
	 * @return {}
	 */
	me.dateAddMonth = function(offset, date) {
		var tempDate;
		if (date) {
			tempDate = new Date(date.getFullYear(), date.getMonth() + offset, date.getDate());
		} else {
			tempDate = new Date();
			tempDate.setMonth(tempDate.getMonth + offset);
		}
		return tempDate;
	}

	/**
	 * 获取yyyyMM格式的日期
	 * @param {} date	基础日期
	 * @param {} separator	年月分隔符 yyyy-MM
	 */
	me.getMonth = function(date, separator) {
		var date = date == null ? me.dateAddDayStr(0) : date;
		var s = date+"";
		s = s.substring(0, 6);
		if (separator) {
			return s.substring(0, 4) + separator + s.substring(4, s.length);
		} else {
			return s;
		}
	}

	me.getYear = function(date) {
		var date = date == null ? me.dateAddDayStr(0) : date;
		var s = date+"";
		return s.substring(0, 4);
	}

	/**
	 * 判断一个变量是否为空 空指针、空字符串、空数组、空对象
	 */
	me.isEmpty = function(s) {
		var bool = false;
		if (s) {
			if (typeof s == "string") {
				if (!$.trim(s) || s == "null") {
					bool = true;
				}
			} else {
				if (s instanceof Array && Array.length == 0) {
					bool = true;
				} else if (s instanceof Object) {
					var hasProperty = false;
					for (var key in s) {
						if (s.hasOwnProperty(key)) {
							hasProperty = true;
						}
						break;
					}
					if (!hasProperty) {
						bool = true;
					}
				}
			}
		} else {
			bool = true;
		}
		return bool;
	}

	me.trim = function(s) {
		return s == null ? "" : s.toString();
	}


	 me.objectFindValue = function(data, key, def) {
		 if (data == null || data[key] == null) {
			 return def;
		 }
		 return data[key];
	 }
	 me.arrayFindExist = function(arr, key) {
		 if (arr == null) {
			 return false;
		 }
		 for (var i = 0; i < arr.length; i++) {
			 if (arr[i][key] != null) {
				 return true;
			 }
		 }
		 return false;
	 }

	 me.compare = function(propertyName, sortType, map) {
		 sortType = sortType || 0;
		 return function(object1, object2) {
			 var value1, value2;
			 value1 = object1[propertyName] || 0;
			 value2 = object2[propertyName] || 0;
			 if (map) {
				 value1 = map[value1] || 0;
				 value2 = map[value2] || 0;
			 }
			 if (value2 < value1) {
				 return sortType == 1 ? -1 : 1;
			 } else if (value2 > value1) {
				 return sortType == 1 ? 1 : -1;
			 } else {
				 return 0;
			 }
		 }
	 }

	 me.replaceObj = function(s, obj, split1, split2, clearAll) {
		 split1 = split1 || "#";
		 split2 = split2 || split1;
		 clearAll = clearAll || true;
		 if (s == null || s == '') {
			 return s;
		 }
		 s = s + "";
		 obj = obj || {};
		 for (var key in obj) {
			 s = s.replace(new RegExp(split1 + key + split2, "gm"), obj[key]);
		 }
		 if (clearAll) {
		 	s = s.replace(new RegExp("#[a-zA-Z0-9\\-_]*#", "gm"), null);
		 }
		 return s;
	 }

	return me;
}(Common || {}));

/**
 * 加载扩展模块，例如要使用弹出用户填写内容输入框layer.prompt()则需要加载
 */
function loadExtend() {
	layer.config({
		extend: 'extend/layer.ext.js'
	});
}

$(function () {
	Common.init();
});