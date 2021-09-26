<a class="btn mb-3 btn-primary" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Message editor
</a>
<div class="collapse <#if message??>show</#if>" id="collapseExample">
    <div class="form-group mb-3">
        <form method ="post" enctype="multipart/form-data">
            <div class="form-group mb-3">
                <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                    value="<#if message??>${message.text}</#if>" name="text" placeholder="Введите сообщение" />
                <#if textError??>
                <div class="invalid-feedback">
                    ${textError}
                </div>
                </#if>
            </div>
            <div class="form-group mb-3">
                <input type="text" class="form-control"
                    value="<#if message??>${message.tag}</#if>" name="tag" placeholder="Тэг">
                <#if tagError??>
                       <div class="invalid-feedback">
                              ${tagError}
                       </div>
                </#if>
            </div>
            <div class="custom-file">
                <input name="file"  class="form-control" type="file" id="customFile">
                <label for="customFile" class="formFile"></label>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="hidden" name="id" value="<#if message??>${message.id}</#if>" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Save message</button>
            </div>
        </form>
    </div>
</div>