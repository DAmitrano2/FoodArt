<%@include file="./include/header.jsp"%>
<div class="container">
    <div class="d-flex justify-content-center">
        <div class="col-sm-6">
            <div class="card">
                <div class="cc-card-header">
                    <strong>Inserisci un nuovo indirizzo</strong>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="name">Nome</label>
                                <input class="form-control" name="name" type="text" placeholder="Inserisci il nome">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="surname">Cognome</label>
                                <input class="form-control" name="surname" type="text" placeholder="Inserisci il cognome">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="road">Via</label>
                                <input class="form-control" name="road" type="text" placeholder="Inserisci il nome della strada">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="hnumber">Nr&#176; Civico</label>
                                <input class="form-control" name="hnumber" type="text" placeholder="Inserisci il numero civico">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="city">Citt&#224;</label>
                                <input class="form-control" name="city" type="text" placeholder="Inserisci la citt&#224;">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="cap">CAP</label>
                                <input class="form-control" name="cap" type="text" placeholder="Inserisci il codice postale">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="province">Provincia</label>
                                <input class="form-control" name="province" type="text" placeholder="Inserisci la provincia (AA)">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="tnumber">Nr&#176; di Telefono</label>
                                <input class="form-control" name="tnumber" type="text" placeholder="Inserisci il numero di telefono">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addInfo">Informazioni aggiuntive</label>
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="Piano, interno, ecc" style="resize: none;"></textarea>
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
<%@include file="./include/footer.html"%>
<%@include file="./include/script.html"%>