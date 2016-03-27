var windowHeight = $(window).height();
var mainHeaderHeight = $(".main-header").height();
var codeContainerHeight = windowHeight - mainHeaderHeight;

$(".code-container").height(codeContainerHeight + "px");

$(".toggle").click(function() {

	$(this).toggleClass("selected");
	var activeDiv = $(this).html();
	$("#" + activeDiv + "-container").toggle();

	var showingDivs = $(".code-container").filter(function() {

		return($(this).css("display") != "none");

	}).length;

	var showingDivsWidth = 100 / showingDivs;
	$(".code-container").width(showingDivsWidth + "%");
});

$("#run-button").click(function() {

	$("iframe").contents().find("html").html('<style>' + $("#css-code").val() + '</style>' + $("#html-code").val());

	document.getElementById("result-frame").contentWindow.eval($("#js-code").val());

		});
