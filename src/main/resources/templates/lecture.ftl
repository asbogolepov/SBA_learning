<#import "parts/common.ftl" as c>

<@c.page>
    <a href="/test">Take a test</a>

    <#list lectures as lecture>
        <div>
            <b><a name="${lecture.lectureTechName}"></a>${lecture.lectureName}<br></b>
            <i>${lecture.lectureContent}<br><br></i>
        </div>
    </#list>

    <div>
        <b>Adding lectures</b>
    </div>
    <form action="/lecture" method="post">
        <div><label> Lecture Name : <input type="text" name="lectureName"/> </label></div>
        <div><label> Lecture Content: <input type="text" name="lectureContent"/> </label></div>
        <input type="hidden" name="_csrf" value="${ _csrf.token }"/>
        <div><input type="submit" value="Add Lecture"/></div>
    </form>

    <a href="#lecture 2">Лекция 4</a>


    <div><a href="/">To the beginning</a></div>
</@c.page>


