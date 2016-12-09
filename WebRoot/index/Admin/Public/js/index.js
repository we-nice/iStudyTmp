// JavaScript Document
$(document).ready(function(){
	var rightheight=leftheight=$(window).height();
	var rightwidth=$(window).width()-200;
	$('#left').height(leftheight);
	$('#right').height(rightheight);
	$('#right').width(rightwidth);
 
	objclick($('#left p'));
 
 
	})
function objclick(obj){
	 
 
		obj.click(function(){
		$(this).parent().siblings().find('p').removeClass('current');
		$(this).addClass('current').siblings().removeClass('current');
		});
	}
