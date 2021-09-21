<#import "parts/common.ftlh" as c>

<@c.page>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" value="${filter?ifExists}" placeholder="Search by tag">
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>

<a class="btn mb-3 btn-primary" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new message
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mb-3">
        <form method ="post" enctype="multipart/form-data">
            <div class="form-group mb-3">
                <input type="text" class="form-control" name="filter" placeholder="Введите сообщение">
            </div>
            <div class="form-group mb-3">
                <input type="text" class="form-control" name="tag" placeholder="Тэг">
            </div>
            <div class="custom-file">
                <input name="file"  class="form-control" type="file" id="customFile">
                <label for="customFile" class="formFile"></label>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Add new file</button>
            </div>
        </form>
    </div>
</div>
<div class="row row-cols-1 row-cols-md-4 g-4">
    <#list messages as message>
    <div class="col">
    <div class="card h-100">
        <#if message.filename??>
            <img src="/img/${message.filename}" class="card-img-top">
        </#if>

        <div class="p-2">
        <span>${message.text}</span>
        <i>${message.tag}</i>
        </div>

        <div class="card-footer text-muted">
            ${message.authorName}
        </div>
    </div>
    </div>
    <#else>
    No message
    </#list>
</div>
</@c.page>