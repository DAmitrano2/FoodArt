<%@include file="./include/header.jsp"%>
<div class="container">
    <div class="d-flex justify-content-center">
        <div class="col-sm-6">
            <div class="card">
                <div class="cc-card-header">
                    <strong>Inserisci una nuova carta di credito</strong>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label for="name">Nome dell'intestatario</label>
                                <input class="form-control" id="nm" type="text" placeholder="Inserisci nome e cognome" autocomplete="cc-name">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label for="ccnumber">Numero della carta</label>
                                <div class="input-group">
                                    <input class="form-control" type="text" id="ccnum" placeholder="0000 0000 0000 0000" autocomplete="cc-number">
                                    <div class="input-group-append">
                                        <span id="ct" class="input-group-text">
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label for="cvv">Data di Scadenza</label>
                                <input class="form-control" id="ex" type="text" placeholder="MM / YY">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label for="cvv">CVV/CVC</label>
                                <input class="form-control" id="cv" type="text" placeholder="123">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="cc-card-footer">
                    <button class="btn float-right" id="btnsub" type="submit">Invia</button>
                    <div id="result" class="emoji"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--
    <div class="cc-container">
        <div class="cc-form w3-row">
            <div class="w3-col m8">
                <label class="w3-text-black">Data di scadenza</label>
                <input type="text" id="ex" name="ex" class="w3-input w3-border w3-round" placeholder="MM / YY">
            </div>
            <div class="w3-col m4 cc-padding-left">
                <label class="w3-text-black">CVV</label>
            <input type="text" id="cv" name="cv" class="w3-input w3-border w3-round" placeholder="---">
            </div>
        </div>
        <div class="cc-form">
            <label class="w3-text-black">Nome</label>
            <input type="text" id="nm" name="nm" class="w3-input w3-border w3-round" placeholder="Nome e cognome dell'intestatario">
        </div>
        <div class="cc-form w3-row">
            <div class="w3-col m5">
                <button id="btnsub" class="w3-button w3-blue">Invia</button>
                <div id="result" class="emoji"></div>
            </div>
            <div class="w3-col m7 cc-padding-left">
                <h4 id="ct" class="w3-text-black cc-uppercase"></h4>
            </div>
        </div>
    </div>
    -->
<script src="./assets/js/payform.min.js"></script>
<script src="./assets/js/add_credit_card.js"></script>
<%@include file="./include/footer.html"%>
<%@include file="./include/script.html"%>