<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="pt-PT">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cordialle Art</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/style.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Alex+Brush&family=Outfit:wght@300;400;500;600&display=swap" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand-lg py-4">
    <div class="container">
        <div class="collapse navbar-collapse w-100 order-1 order-md-0 dual-collapse2">
            <ul class="navbar-nav me-auto"></ul>
        </div>

        <a class="navbar-brand mx-auto order-0 script-font" href="/home">Cordialle Art</a>
        <div class="navbar-collapse collapse w-100 order-3 dual-collapse2 d-flex justify-content-between">
            <ul class="navbar-nav mx-auto align-items-center">
                <li class="nav-item"><a class="nav-link active" href="/home">Loja</a></li>
                <li class="nav-item"><a class="nav-link" href="/quem-somos">Quem somos</a></li>
                <li class="nav-item"><a class="nav-link" href="/galeria">Galeria</a></li>

                <li class="nav-item ms-lg-4">
                    <a class="nav-link fw-bold" style="color: var(--dark-green); border: 2px solid var(--light-green); border-radius: 8px; padding: 5px 15px;"
                       href="/produto/dashboard">
                        <i class="fa-solid fa-lock me-1"></i> DASHBOARD
                    </a>
                </li>
            </ul>
            <div class="nav-icons ms-auto">
                <a href="/carrinho"><i class="fa-solid fa-bag-shopping"></i></a>
                <a href=""><i class="fa-regular fa-user"></i></a>
            </div>
        </div>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target=".dual-collapse2">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>

<section class="container mt-5 py-5">
    <div class="row align-items-center">
        <div class="col-lg-5 pe-lg-5">
            <span class="badge-hero">Feito para você com amor</span>
            <h1 class="display-5 mb-4" style="font-weight: 400;">A arte de presentear de<br>forma única.</h1>
            <p class="text-muted mb-5">Transformamos papel em presentes com memórias. Produtos que materializam sentimentos, deixam a sua marca.</p>
            <div class="d-flex gap-3">
                <a href="/home" class="btn btn-dark-green">Ver Coleção</a>
            </div>
        </div>
        <div class="col-lg-7 mt-5 mt-lg-0">
            <div class="hero-images d-none d-md-block">
                <img src="https://images.unsplash.com/photo-1544816155-12df9643f363?ixlib=rb-4.0.3&auto=format&fit=crop&w=400&q=80" alt="Caderno 1" class="hero-img-1">
                <img src="https://images.unsplash.com/photo-1586075010923-2dd4570fb338?ixlib=rb-4.0.3&auto=format&fit=crop&w=400&q=80" alt="Caderno 2" class="hero-img-2">
            </div>
        </div>
    </div>
</section>

<section class="container mt-5 pt-5">
    <h2 class="section-title">Mais Vendidos</h2>
    <div class="row g-4 mt-4">
        <div class="col-lg-6 position-relative">
            <img src="/img/kitpapbot.jpg" alt="Kit Papelaria" class="w-100 card-img-large">
            <div class="card-large-overlay">
                <h3 class="script-font mb-1 text-white">Kit Papelaria Botânica</h3>
                <p class="mb-0">Coleção Limitada</p>
            </div>
        </div>
        <div class="col-lg-6 d-flex flex-column gap-4">
            <div class="row g-4">
                <div class="col-6">
                    <img src="/img/carimbo.png" alt="Carimbo" class="product-img mb-2">
                    <h6 class="mb-1">Carimbo Personalizado</h6>
                    <span class="text-muted small">R$ 89,90</span>
                </div>
                <div class="col-6">
                    <img src="/img/caderno.jpg" alt="cadernos" class="product-img mb-2">
                    <h6 class="mb-1">Cadernos Custom</h6>
                    <span class="text-muted small">R$ 129,90</span>
                </div>
            </div>
            <div class="row h-100">
                <div class="col-12 h-100">
                    <div class="promo-box row align-items-center m-0">
                        <div class="col-sm-6">
                            <h3 class="script-font text-dark mb-1">Caixas de Presente</h3>
                            <p class="small text-muted mb-3">Guarde suas memórias com charme.</p>
                        </div>
                        <div class="col-sm-6 text-end mt-3 mt-sm-0">
                            <img src="/img/caixa.jpg" alt="Caixa" class="img-fluid rounded" style="max-height: 150px; object-fit: cover;">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="container mt-5 pt-5 text-center">
    <h2 class="title-font mb-1">Galeria de Inspiração</h2>
    <p class="text-muted small mb-5">Veja mais de perto o nosso trabalho</p>
    <div class="row g-3">
        <div class="col-md-4"><img src="/img/pap1.jpg" class="gallery-img"></div>
        <div class="col-md-4"><img src="/img/pap2.jpg" class="gallery-img"></div>
        <div class="col-md-4"><img src="/img/pap3.jpg" class="gallery-img"></div>
        <div class="col-md-4"><img src="/img/pap4.webp" class="gallery-img"></div>
        <div class="col-md-4"><img src="/img/pap5.jpg" class="gallery-img"></div>
        <div class="col-md-4"><img src="/img/pap6.jpg" class="gallery-img"></div>
    </div>
</section>

<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-4 mb-4 mb-lg-0">
                <h3 class="script-font text-white mb-3">Cordialle Art</h3>
                <p class="text-white-50 small mb-4">Criamos cadernos feitos à mão e papelaria sustentável.</p>
            </div>
            <div class="col-lg-2 offset-lg-2 col-6">
                <h6 class="text-white mb-3">Links</h6>
                <a href="/home">Loja</a>
                <a href="/galeria">Galeria</a>
                <a href="/quem-somos">Sobre Nós</a>
            </div>
        </div>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>