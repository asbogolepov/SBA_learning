<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div>
        <@l.logout />
        <span><a href="/user">User list</a> </span>
    </div>
    <div>
        <form method="post" action="main" enctype="multipart/form-data">
            <input type="text" name="text" placeholder="Enter the message">
            <input type="text" name="tag" placeholder="Tag">
            <input type="file" name="file">
            <input type="hidden" name="_csrf" value="${ _csrf.token }"/>
            <button type="submit">Add</button>
        </form>
    </div>
    <div>Messages list</div>
    <form method="post" action="filter">
        <input type="text" name="filter">
        <input type="hidden" name="_csrf" value="{{ _csrf.token }}"/>
        <button type="submit">Find</button>
    </form>
    <#list messages as message>
    <div>
        <b>${message.id}</b>`
        <span>${message.text}</span>
        <i>${message.tag}</i>
        <strong>${message.authorName}</strong>
        <div>
            <#if message.filename??>
                <img src="/img/${message.filename}">
            </#if>
        </div>
    </div>
        <#else>
        No messages
    </#list>

</@c.page>
