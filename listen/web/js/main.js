$(function(){
	getTestBoxNum();
	setNum();
	var content = '<div class="testbox" value="">'+
	'<ul>'+

	'<li>'+
	'<label class="layui-form-label">'+'A：'+'</label>'+
	'<div class="layui-input-block">'+
	'<input type="text" name="title" placeholder="请输入" class="layui-input">'+
	'</div>'+
	'</li>'+

	'<li>'+
	'<label class="layui-form-label">'+'B：'+'</label>'+
	'<div class="layui-input-block">'+
	'<input type="text" name="title" placeholder="请输入" class="layui-input">'+
	'</div>'+
	'</li>'+

	'<li>'+
	'<label class="layui-form-label">'+'C：'+'</label>'+
	'<div class="layui-input-block">'+
	'<input type="text" name="title" placeholder="请输入" class="layui-input">'+
	'</div>'+
	'</li>'+

	'<li>'+
	'<label class="layui-form-label">'+'D：'+'</label>'+
	'<div class="layui-input-block">'+
	'<input type="text" name="title" placeholder="请输入" class="layui-input">'+
	'</div>'+
	'</li>'+

	'<li>'+
	'<label class="layui-form-label">'+'正确答案：'+'</label>'+
	'<div class="layui-input-block">'+
	'<select lay-ignore>'+
	'<option value="A">'+'A'+'</option>'+
	'<option value="B">'+'B'+'</option>'+
	'<option value="C">'+'C'+'</option>'+
	'<option value="D">'+'D'+'</option>'+
	'</select>'+
	'</div>'+
	'</li>'+
	
	'</ul>'+
	'<div class="closebox" onclick="del(this)">'+
		'<i class="layui-icon">'+'&#x1007;'+'</i>'+
	'</div>'+
	'</div>';

	$('#addbtn').click(function(){
		$(this).prev().after(content);
		getTestBoxNum();
		setNum();
	})

	// 获得总共多少div数量
	function getTestBoxNum(){
		var testBoxNum = $('div.testbox');
		$('#testNum').html(testBoxNum.length);
	}

	function setNum(){
		var testBoxNum = $('div.testbox');
		for(var i=0;i<testBoxNum.length;i++){
			testBoxNum.eq(i).attr('value',i+1);
            var lis = testBoxNum.eq(i).find("li");
            lis.eq(0).find("input").attr("name","subjectList["+i+"].optionA");
            lis.eq(1).find("input").attr("name","subjectList["+i+"].optionB");
            lis.eq(2).find("input").attr("name","subjectList["+i+"].optionC");
            lis.eq(3).find("input").attr("name","subjectList["+i+"].optionD");
            lis.eq(4).find("select").attr("name","subjectList["+i+"].answer");
       /* <input type="text" name="subjectList[0].sort"/>
                <input type="text" name="subjectList[0].answer"/>
                <input type="text" name="subjectList[0].optionA"/>
                <input type="text" name="subjectList[0].optionB"/>
                <input type="text" name="subjectList[0].optionC"/>
                <input type="text" name="subjectList[0].optionD"/>
                <input type="text" name="subjectList[0].analysis"/>*/
			// text(i+1);
		}
	}
});
