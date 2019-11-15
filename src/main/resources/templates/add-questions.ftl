<#import "parts/common.ftl" as c>

<@c.page>

<div>
<b>Adding questions</b>
</div>
<form action="/add-questions" method="post">
    <div><label> Question Name : <input type="text" name="questionName"/> </label></div>
    <div><label> Option One: <input type="text" name="optionOne"/> </label></div>
    <div><label> Option Two: <input type="text" name="optionTwo"/> </label></div>
    <div><label> Option Three: <input type="text" name="optionThree"/> </label></div>
    <div><label> Option Four: <input type="text" name="optionFour"/> </label></div>
    <div><label> Lecture Id: <input type="text" name="lectureId"/> </label></div>
    <div><label> Right Answer: <input type="text" name="rightAnswer"/> </label></div>
    <input type="hidden" name="_csrf" value="${ _csrf.token }"/>
    <div><input type="submit" value="Add Question"/></div>
</form>
</@c.page>