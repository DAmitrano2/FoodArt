<%@include file="./include/header.jsp"%>
<link rel="stylesheet" href="./assets/css/recap_order_style.css">
<div class="container rounded bg-white">
    <div class="row d-flex justify-content-center pb-5">
        <div class="col-sm-5 col-md-5 ml-1">
            <div class="d-flex pt-2">
                <div>
                    <p><b>INDIRIZZO</b></p>
                </div>
                <div class="ml-auto">
                    <p id="media-plus"><i class="fa fa-plus-circle text-primary"></i></p>
                    <p class="text-primary"><i class="fa fa-plus-circle text-primary"></i> Aggiungi un nuovo indirizzo </p>
                </div>
            </div>
            <div class="rounded d-flex">
                <ul>
                    <li>Alfonso Zappia</li>
                    <li>Via dello Stadio 18</li>
                    <li>Secondo Piano</li>
                    <li>Pagani, SA, 84016</li>
                </ul>
            </div>
            <hr>
            <div class="pt-2">
                <div class="d-flex pt-2">
                    <div>
                        <p><b>PAGAMENTO</b></p>
                    </div>
                    <div id="payment" class="ml-auto p-2">
                        <p id="media-plus"><i class="fa fa-plus-circle text-primary"></i></p>
                        <p class="text-primary"><i class="fa fa-plus-circle text-primary"></i> Aggiungi metodo di pagamento</p>
                    </div>
                </div>
                <form class="pb-3">
                    <div class="d-flex flex-row align-content-center">
                        <div class="pt-2 pr-2"><input type="radio" name="creditcard" id="radio1" checked></div>
                        <div class="rounded border d-flex w-100 px-2">
                            <div class="pt-2">
                                <p id="media-card"><i class="fa fa-cc-visa text-primary pr-2"></i></p>
                                <p><i class="fa fa-cc-visa text-primary pr-2"></i>Visa termina con</p>
                            </div>
                            <div class="ml-auto pt-2">************3456</div>
                        </div>
                    </div>
                </form>
                <form class="pb-3">
                    <div class="d-flex flex-row align-content-center">
                        <div class="pt-2 pr-2"><input type="radio" name="creditcard" id="radio2"></div>
                        <div class="rounded border d-flex w-100 px-2">
                            <div class="pt-2">
                                <p id="media-card"><i class="fab fa-cc-mastercard text-primary pr-2"></i></p>
                                <p><i class="fab fa-cc-mastercard text-primary pr-2"></i>Mastercard termina con</p>
                            </div>
                            <div class="ml-auto pt-2">************7891</div>
                        </div>
                    </div>
                </form>
            </div>
            <hr>
            <div> <input type="button" value="Acquista ora" class="btn btn-primary btn-block"> </div>
        </div>
    </div>
</div>