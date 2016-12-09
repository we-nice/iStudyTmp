// JavaScript Document
$(document).ready(function(){
	 
		/*点击滚动*/
	var A={"float":"left",position:"relative"};
	var	E={"float":"none",position:"absolute"};
	var time=700;
	$("#content_ad li:eq(0)").css({"display": "list-item", "float": "left", "position": "relative"});
	$("#content_tab li").click(function(){
		$("#content_tab li").removeClass("background");
		$(this).addClass("background");
		var index=$(this).index();
		$("#content_ad li").fadeOut(time,function(){
			$(this).css(E);
		}).eq(index).fadeIn(time,function(){
			$(this).css(A);
		});
		})
		/*循环滚动*/
		var t=2;
		function slide(){
			if(t!=3){
			$("#content_ad li").fadeOut(time,function(){
				$(this).css(E);
			}).eq(t-1).fadeIn(time,function(){
				$(this).css(A);
			});
				t++;
			}
			else{
			$("#content_ad li").fadeOut(time,function(){
			$(this).css(E);
			}).eq(t-1).fadeIn(time,function(){
				$(this).css(A);
			});
					t=1;
					}
				$("#content_tab li").removeClass("background").eq(t-2).addClass("background");
				d=setTimeout(slide,3000);
				}
			d=setTimeout(slide,3000);
		 $("#content_ad,#content_tab").hover(function(){
			clearTimeout(d);
			},function(){
			d=setTimeout(slide,3000);
				})





    	 
		//弹出修改资料
		$("#example1").hover(function () {
			$(this).stop().animate({
				opacity: '0.6'
			}, 600);
		}, function () {
			$(this).stop().animate({
				opacity: '1'
			}, 1000);
		}).on('click', function () {
			$("body").append("<div id='mask'></div>");
			$("#mask").addClass("mask").fadeIn("slow");
			$("#UpdateNicBox").fadeIn("slow");
		});
		//
		//按钮的透明度
		$("#loginbtn").hover(function () {
			$(this).stop().animate({
				opacity: '1'
			}, 600);
		}, function () {
			$(this).stop().animate({
				opacity: '0.8'
			}, 1000);
		});
 
		$(".close_btn").hover(function () { $(this).css({ color: 'black' }) }, function () { $(this).css({ color: '#999' }) }).on('click', function () {
			$("#UpdateNicBox").fadeOut("fast");
			$("#mask").css({ display: 'none' });
		});
 
//弹出修改密码
		$("#example2").hover(function () {
			$(this).stop().animate({
				opacity: '0.6'
			}, 600);
		}, function () {
			$(this).stop().animate({
				opacity: '1'
			}, 1000);
		}).on('click', function () {
			$("body").append("<div id='mask'></div>");
			$("#mask").addClass("mask").fadeIn("slow");
			$("#UpdatePassBox").fadeIn("slow");
		});
		//
		//按钮的透明度
		$("#loginbtn").hover(function () {
			$(this).stop().animate({
				opacity: '1'
			}, 600);
		}, function () {
			$(this).stop().animate({
				opacity: '0.8'
			}, 1000);
		});
 
		$(".close_btn").hover(function () { $(this).css({ color: 'black' }) }, function () { $(this).css({ color: '#999' }) }).on('click', function () {
			$("#UpdatePassBox").fadeOut("fast");
			$("#mask").css({ display: 'none' });
		});
 
	 
          $("#userDescription").css({ display: 'none' });
         	$("#user").hover(function(){
		         $("#userDescription").css({ display: 'block' });
		},function(){

			  $("#userDescription").css({ display: 'none' });
		})



       $(".des").css({ display: 'none'});

         $(".t1").hover(function(){
         	 
             $(this).children(".des").css({ display: 'block' });
		},function(){
			    $(this).children(".des").css({ display: 'none' });
		})  
})



