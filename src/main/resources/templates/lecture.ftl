<#import "parts/common.ftl" as c>

<@c.page>

    <#list lectures as lecture>

        <div class="col-md-12 card mb-4 shadow-sm" style="width: 18rem;">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal">${lecture.lectureName}</h4>
            </div>
            <div class="card-body">

<#--                <h4 class="card-title pricing-card-title"><small class="text-muted">${lecture.lectureName}</small></h4>-->
                <b><a name="${lecture.id}"></a>${lecture.lectureName}<br></b>
                <i>${lecture.lectureContent}<br><br></i>
            </div>
        </div>

    </#list>

    <div class="col-md-12 card mb-4 shadow-sm" style="width: 18rem;">
        <div class="card-header">
            <h4 class="my-0 font-weight-normal">Добавление лекций</h4>
        </div>
        <div class="card-body">


            <form action="/lecture" method="post">
                <div class="form-group-row">
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="Имя лекции" name="lectureName"/>
                    </div>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="Текст лекции" name="lectureContent"/>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${ _csrf.token }"/>
                <div><input class="btn btn-light" type="submit" value="Добавить лекцию"/></div>
            </form>
        </div>
    </div>

</@c.page>


