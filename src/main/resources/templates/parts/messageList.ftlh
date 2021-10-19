<#include "security.ftlh">
<#import "pager.ftlh" as p>

<@p.pager url page/>
<div class="row row-cols-1 row-cols-md-4 g-4" id="message-list">
    <#list page.content as message>
    <div class="col">
    <div class="card h-100" id="${message.id}">
        <#if message.filename??>
            <img src="/img/${message.filename}" class="card-img-top"/>
        </#if>

        <div class="p-2">
        <span>${message.text}</span><br/>
        <i>#${message.tag}</i>
        </div>

        <div class="card-footer text-muted container">
            <div class="row">
                <a class="col align-self-center" href="/user-messages/${message.author.id}">${message.authorName}</a>
                <a class="col align-self-center" href="/messages/${message.id}/like">
                    <#if message.meLiked>
                        <i class="fas fa-heart"></i>
                    <#else>
                        <i class="far fa-heart"></i>
                    </#if>
                    ${message.likes}
                </a>
                <#if message.author.id == currentUserId>
                    <a class="col btn btn-primary" href="/user-messages/${message.author.id}?message=${message.id}">
                        Edit
                    </a>
                </#if>
            </div>
        </div>
    </div>
    </div>
    <#else>
    No message
    </#list>
</div>

<@p.pager url page/>