$(document).ready(function(){
		//动态加载导航
		//清空原有导航
		//判断是否是admin,是否隐藏学校下拉
		var account=$("#account").val();
		account = account || "";
		
		/*if(account!="admin"){
			
			$.ajax({
				url : "/management/permissions",
				type : "GET",
				async : false,
				data : {},
					for (var int = 0; int < data.length; int++) {
						
					}
				}
			});*/
			
			
			$(".sidebar-menu").html("");
			var str  = '<li class="header">主导航</li>';
				str += '<li class=""><a href="/panel"><i class="fa fa-home"></i><span>首页</span></a></li>';
				str += '<li class=""><a href="/management/"><i class="fa fa-cog"></i><span>学期管理</span></a></i>';
			//$(".sidebar-menu").append('<li class=""><a href="/panel"><i class="fa fa-home"></i><span>首页</span></a></li><li class=""><a href="/management/"><i class="fa fa-cog"></i><span>学期管理</span></a></i>');
			//$(".sidebar-menu").append('<li class=""><a href="/management/grade/index"><i class="fa fa-cog"></i><span>年级管理</span></a></li>');
		}
		
		
	var urlstr = location.href;//得到当前页面的地址栏路径
	var urlstatus = false;//
	if($(".breadcrumb li").eq(2).html()!=undefined){
		$("#sidebar-menu li a").each(function() {
			if($(".breadcrumb li").eq(2).find("a").attr("href").indexOf($(this).attr('href')) > -1 && $(this).attr('href') != '') {
				$(this).parent("li").addClass("active");
				$(this).parent("li").parent(".treeview-menu").parent("li").addClass("active");
				urlstatus = true;
			} else {
				$(this).parent("li").removeClass("active");
			}
		});
	}else{
		$("#sidebar-menu li a").each(function() {
			if((urlstr + '/').indexOf($(this).attr('href')) > -1 && $(this).attr('href') != '') {
				$(this).parent("li").addClass("active");
				$(this).parent("li").parent(".treeview-menu").parent("li").addClass("active");
				urlstatus = true;
			} else {
				$(this).parent("li").removeClass("active");
			}
		});
	}
	if(!urlstatus) {
		$("#sidebar-menu li a").eq(0).parent("li").addClass("active");
	}
	
	//全局提示控件
	$(".prompt").css("left",($("body").width()-$(".prompt").width())/2+"px");
	$(window).resize(function(){
		$(".prompt").css("left",($("body").width()-$(".prompt").width())/2+"px");
	})
		
});

var Timing=5;
window.setInterval(function(){
	Timing++;
},1000);
//全局提示
function Prompt(state,text){
	if(state=="warning" && Timing>=5){
	    Timing=0;
		//警告
		if(text!=""){
			$(".prompt_warning p").text(text);
		}else{
			$(".prompt_warning p").text("警告");
		}
		$(".prompt").css("left",($("body").width()-$(".prompt").width())/2+"px");
		$(".prompt_warning").removeClass("fadeOutUp fadeInUp animated");
		$(".prompt_warning").css("display","block").addClass("fadeInUp animated");
		$('.prompt_warning').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
	    	$(this).removeClass("fadeInUp animated");
	    	window.setTimeout(function(){
	    		$('.prompt_warning').addClass("fadeOutUp animated");
	    		$('.prompt_warning').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
			    	$(this).removeClass("fadeOutUp animated").css("display","none");
			    });
	    	},1500);
	    });
	}else if(state=="fail" && Timing>=5){
	    Timing=0;
		//失败
		if(text!=""){
			$(".prompt_fail p").text(text);
		}else{
			$(".prompt_fail p").text("失败");
		}
		$(".prompt").css("left",($("body").width()-$(".prompt").width())/2+"px");
		$(".prompt_fail").css("display","block").addClass("fadeInUp animated");
		$('.prompt_fail').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
	    	$(this).removeClass("fadeInUp animated");
	    	window.setTimeout(function(){
	    		$('.prompt_fail').addClass("fadeOutUp animated");
	    		$('.prompt_fail').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
			    	$(this).removeClass("fadeOutUp animated").css("display","none");
			    });
	    	},1500);
	    });
	}else if(state=="success" && Timing>=5){
	    Timing=0;
		//成功
		if(text!=""){
			$(".prompt_success p").text(text);
		}else{
			$(".prompt_success p").text("成功");
		}
		$(".prompt").css("left",($("body").width()-$(".prompt").width())/2+"px");
		$(".prompt_success").css("display","block").addClass("fadeInUp animated");
		$('.prompt_success').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
	    	$(this).removeClass("fadeInUp animated");
	    	window.setTimeout(function(){
	    		$('.prompt_success').addClass("fadeOutUp animated");
	    		$('.prompt_success').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
			    	$(this).removeClass("fadeOutUp animated").css("display","none");
			    });
	    	},1500);
	    });
	}
	
}
