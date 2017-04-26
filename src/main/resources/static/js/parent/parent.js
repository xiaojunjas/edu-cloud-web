$(function () {

//声明列表复选
	opt.checkbox(".j-che-lis-1",".j-che-1");
	
	
	
	/*** 搜索框条件查询*/
	$("#query").keydown(function(event) {  
		if(event.keyCode == 13){
			event.preventDefault();
			current=1;
			parent();
	    }
	});
	    
	$("#but_query").click(function(){
			current=1;
			parent();
	});

	
    var current=1;
    var limit = 10;
    var params={'start':0,'limit':limit,'query':null};
    parent();
    function paramsing(){
    	var query = $("#query").val();
    	params['query']=query;
    	params['start']=current-1;
    	params['limit']=limit;
    }
        
    function parent(){
    	paramsing();
    	$("#parentList").empty();
    	$.ajax({
    		type:"get",
    		url:"/cloud/parents",
    		data:params,
    		success : function(data){
    			$("#parentListTemplate").tmpl(data).appendTo("#parentList");
    			pageing(data.count);
    		},error:function(data){
    			alert("出现错误信息!");
    		}
    	});
      }

    /**
     * 分页事件
     */
    function pageing(count){
    	if(count<1) {
    		$(".pagination").empty();
    		return false;
    	}
    	var totalPage = parseInt(count/limit)+((count%limit)>0?1:0);
    	if(totalPage>1){
    		$(".pagination").show();
	    	$(".pagination").bootstrapPaginator({
	    		bootstrapMajorVersion: 3.0,
	    		currentPage: current,
	    		totalPages: totalPage,
	    		numberOfPages: limit,
	    		itemTexts: function (type, page, currentpage) {
	                switch (type) {
	    	            case "first": return "首页";
	    	            case "prev" : return "上一页";
	    	            case "next" : return "下一页";
	    	            case "last" : return "尾页";
	    	            case "page" : return page;
	                }
	            },onPageClicked: function(event, originalEvent, type, page){
	    			if(current == page){
	    				return false;
	    			}
	    			current = page;
	    			parent();
	    		}
	    	});
		}else{
			$(".pagination").hide();
		}
    };    
    
})