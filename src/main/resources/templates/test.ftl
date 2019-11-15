<#import "parts/common.ftl" as c>

<@c.page>

<div>
<b>Take a test</b>
</div>
<#list questions as question>
     <form action="/test" method="post">
         <b>${question.questionName}</b>
         <div> <input type="hidden" name="questionId" value="${question.id}"> </div>
<#--         <#list answers as answer>-->
<#--         <div> <input type="hidden" name="answerId" value="${answer.id}"> </div>-->

<#--         </#list>-->
         <div><label> <input type="radio" name="selectedOption" value="${question.optionOne}"> ${question.optionOne}<br> </label></div>
         <div><label> <input type="radio" name="selectedOption" value="${question.optionTwo}"> ${question.optionTwo}<br> </label></div>
         <div><label> <input type="radio" name="selectedOption" value="${question.optionThree}"> ${question.optionThree}<br> </label></div>
         <div><label> <input type="radio" name="selectedOption" value="${question.optionFour}"> ${question.optionFour}<br> </label></div>



<#--         <div><label> Selected Option: <input type="text" name="selectedOption"/> </label></div>-->


         <input type="hidden" name="_csrf" value="${ _csrf.token }"/>
         <div><input type="submit" value="Answer"/></div>
         <#if (answer.selectedOption)??>
         <b>${question.compareAnswer(answer.selectedOption)?string('Верно', 'Неверно, ${question.lectureId}')}</b>
            <#if !question.compareAnswer(answer.selectedOption)>
                <a href="/lecture#${question.lectureId}">Лекция ${question.lectureId}</a>
            </#if>
         </#if>
<#--         <div>${question.compareAnswer()}</div>-->
     </form>
</#list>

</@c.page>