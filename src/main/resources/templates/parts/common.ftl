<#macro page>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Изучение БД</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="/static/style.css">
    <link rel="stylesheet" href="/static/bootstrap.css  ">
<#--    <link rel="stylesheet" href="/static/style.css">-->
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
</head>


<body>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">

    <h5 class="my-0 mr-md-auto font-weight-normal">Компьютерная обучающая система работы с базами данных</h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="/lecture">Лекции</a>
        <a class="p-2 text-dark" href="/test">Пройти тестирование</a>
        <a class="p-2 text-dark" href="/add-questions">Добавить вопросы</a>
    </nav>
</div>
<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <h1 class="display-4">Изучение баз данных</h1>
</div>
<div class="container">
    <div class="row">
        <#nested>
    </div>
</div>

</body>
</html>
</#macro>