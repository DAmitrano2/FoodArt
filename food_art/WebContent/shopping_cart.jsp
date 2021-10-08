<%@include file="./include/header.jsp"%>
<link rel="stylesheet" href="./assets/css/shopping_cart_style.css">
<div class="container-fluid">
    <div class="row">
        <aside class="col-lg-9">
            <div class="card">
                <div class="table-responsive">
                    <table class="table table-borderless table-shopping-cart">
                        <thead class="text-muted">
                            <tr class="small text-uppercase">
                                <th scope="col">Prodotti</th>
                                <th scope="col" width="120">Quantità</th>
                                <th scope="col" width="120">Prezzo</th>
                                <th scope="col" class="text-right d-none d-md-block" width="200"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <figure class="itemside align-items-center">
                                        <div class="aside"><img src="./assets/images/conserve1.jpg" class="img-sm"></div>
                                        <figcaption class="info"> <a href="#" class="title-cart text-dark" data-abc="true">Confettura di Albicocche</a>
                                            <p class="text-muted small">QT: pz <br> da: <a href="#">Rivenditore</a></p>
                                        </figcaption>
                                    </figure>
                                </td>
                                <td> <select class="form-control">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                </select> </td>
                                <td>
                                    <div class="price-wrap"><var class="price">&#8364; 5,00</var></div>
                                </td>
                                <td class="text-right d-none d-md-block"><a href="" class="btn btn-light" data-abc="true"><i class="fas fa-trash-alt"></i> Rimuovi</a> </td>
                            </tr>
                            <tr>
                                <td>
                                    <figure class="itemside align-items-center">
                                        <div class="aside"><img src="./assets/images/conserve2.jpg" class="img-sm"></div>
                                        <figcaption class="info"> <a href="#" class="title-cart text-dark" data-abc="true">Peperoni sott'Olio</a>
                                            <p class="text-muted small">QT: pz <br> da: <a href="#">Rivenditore</a></p>
                                        </figcaption>
                                    </figure>
                                </td>
                                <td> <select class="form-control">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                </select> </td>
                                <td>
                                    <div class="price-wrap"><var class="price">&#8364; 5,00</var></div>
                                </td>
                                <td class="text-right d-none d-md-block"><a href="" class="btn btn-light" data-abc="true"><i class="fas fa-trash-alt"></i> Rimuovi</a> </td>
                            </tr>
                            <tr>
                                <td>
                                    <figure class="itemside align-items-center">
                                        <div class="aside"><img src="./assets/images/conserve3.jpg" class="img-sm"></div>
                                        <figcaption class="info"> <a href="#" class="title-cart text-dark" data-abc="true">Confettura di Fragole</a>
                                            <p class="text-muted small">QT: pz <br> da: <a href="#">Rivenditore</a></p>
                                        </figcaption>
                                    </figure>
                                </td>
                                <td> <select class="form-control">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                </select> </td>
                                <td>
                                    <div class="price-wrap"><var class="price">&#8364; 5,00</var></div>
                                </td>
                                <td class="text-right d-none d-md-block"> <a href="" class="btn btn-light" data-abc="true"><i class="fas fa-trash-alt"></i> Rimuovi</a> </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </aside>
        <aside class="col-lg-3">
            <div class="card">
                <div class="card-body">
                    <dl class="dlist-align">
                        <dt>Totale provvisorio:</dt>
                        <dd class="text-right ml-3">&#8364; 15,00</dd>
                    </dl>
                    <hr> <a href="<%=path %>/recap_order.jsp" class="btn btn-out btn-primary btn-square btn-main" data-abc="true"><i class="fas fa-check-square"></i> Procedi all'ordine </a> <a href="#" class="btn btn-out btn-success btn-square btn-main mt-2" data-abc="true"><i class="fas fa-arrow-circle-left"></i> Continua lo shopping</a>
                </div>
            </div>
        </aside>
    </div>
</div>