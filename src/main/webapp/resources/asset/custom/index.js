$(document).ready(function(){
	$.ajax({
		type:"POST",
	
		url:'getNotes',
		
		success:function(data){
			var list ="";
			
			$(data).each(function(i,val){
				list = list
				+'<article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12>'
				+'<span class="fh5co-meta"><a href="single.html">'+val.title+'</a></span>'
				+'<h2 class="fh5co-article-title"><a href="single.html">Blog Başlığı</a></h2>' 
				+'<h3><a href="single.html"  style="color:#999999">'+val.content+'</h3>'
				+'<span class="fh5co-meta fh5co-date">'+val.create_date+'</span>'
	
			    +'</article>';
			
			
			});
               $("#list").html(list);			
			
		},error:function(data){
			alert(data)
		}
		
		
	});
});