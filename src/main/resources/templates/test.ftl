<#import "parts/common.ftl" as c>

<@c.page>

<div>
    <p class="lead">Тестирование</p>
</div>
<#list questions as question>

    <div class="col-md-12 card mb-4 shadow-sm" style="width: 18rem;">
        <div class="card-header">
            <h4 class="my-0 font-weight-normal">${question.questionName}</h4>
        </div>
        <div class="card-body">

            <form action="/test" method="post">
                <b>${question.questionName}</b>
                <div> <input type="hidden" name="questionId" value="${question.id}"> </div>

                <div><label> <input type="radio" name="selectedOption" value="${question.optionOne}"> ${question.optionOne}<br> </label></div>
                <div><label> <input type="radio" name="selectedOption" value="${question.optionTwo}"> ${question.optionTwo}<br> </label></div>
                <div><label> <input type="radio" name="selectedOption" value="${question.optionThree}"> ${question.optionThree}<br> </label></div>
                <div><label> <input type="radio" name="selectedOption" value="${question.optionFour}"> ${question.optionFour}<br> </label></div>

                <input type="hidden" name="_csrf" value="${ _csrf.token }"/>
                <div><input type="submit" value="Answer"/></div>
                <#if (answer.selectedOption)??>
                    <b>${question.compareAnswer(answer.selectedOption)?string('Верно', 'Неверно, ${question.lectureId}')}</b>
                    <#if !question.compareAnswer(answer.selectedOption)>
                        <a href="/lecture#${question.lectureId}">Лекция ${question.lectureId}</a>
                    </#if>
                </#if>
            </form>
        </div>
    </div>


<#--     <form action="/test" method="post">-->
<#--         <b>${question.questionName}</b>-->
<#--         <div> <input type="hidden" name="questionId" value="${question.id}"> </div>-->

<#--         <div><label> <input type="radio" name="selectedOption" value="${question.optionOne}"> ${question.optionOne}<br> </label></div>-->
<#--         <div><label> <input type="radio" name="selectedOption" value="${question.optionTwo}"> ${question.optionTwo}<br> </label></div>-->
<#--         <div><label> <input type="radio" name="selectedOption" value="${question.optionThree}"> ${question.optionThree}<br> </label></div>-->
<#--         <div><label> <input type="radio" name="selectedOption" value="${question.optionFour}"> ${question.optionFour}<br> </label></div>-->

<#--         <input type="hidden" name="_csrf" value="${ _csrf.token }"/>-->
<#--         <div><input type="submit" value="Answer"/></div>-->
<#--         <#if (answer.selectedOption)??>-->
<#--         <b>${question.compareAnswer(answer.selectedOption)?string('Верно', 'Неверно, ${question.lectureId}')}</b>-->
<#--            <#if !question.compareAnswer(answer.selectedOption)>-->
<#--                <a href="/lecture#${question.lectureId}">Лекция ${question.lectureId}</a>-->
<#--            </#if>-->
<#--         </#if>-->


<#--     </form>-->
</#list>

</@c.page>