(function(){
    var ccnum = document.getElementById('ccnum'),
        type = document.getElementById('ct'),
        expiry = document.getElementById('ex'),
        cvc = document.getElementById('cv'),
        submit = document.getElementById('btnsub'),
        result = document.getElementById('result');

        payform.cardNumberInput(ccnum);
        payform.expiryInput(expiry);
        payform.cvcInput(cvc);

        ccnum.addEventListener('input', updateType);

        submit.addEventListener('click', function() {
            var valid = [], 
            expiryObj = payform.parseCardExpiry(expiry.value);
            valid.push(fieldStatus(ccnum, payform.validateCardNumber(ccnum.value)));
            valid.push(fieldStatus(expiry, payform.validateCardExpiry(expiryObj)));
            valid.push(fieldStatus(cvc, payform.validateCardCVC(cvc.value, type.innerHTML)));
            result.className = 'emoji '+(valid.every(Boolean) ? 'valid' : 'invalid');
        });
        function updateType(e){
            var cardType = payform.parseCardType(e.target.value);
            if(cardType==='visa'){
                type.innerHTML = '<i class="fa-brands fa-cc-visa"></i>' || 'invalid';
            } else if(cardType==='mastercard'){
                type.innerHTML = '<i class="fa-brands fa-cc-mastercard"></i>' || 'invalid';
            } else if(cardType==='amex'){
                type.innerHTML = '<i class="fa-brands fa-cc-amex"></i>' || 'invalid';
            } else if(cardType==='jcb'){
                type.innerHTML = '<i class="fa-brands fa-cc-jcb"></i>' || 'invalid';
            } else if(cardType==='discover'){
                type.innerHTML = '<i class="fa-brands fa-cc-discover"></i>' || 'invalid';
            } else if(cardType==='discover'){
                type.innerHTML = '<i class="fa-brands fa-cc-discover"></i>' || 'invalid';
            } else if(cardType==='dinersclub'){
                type.innerHTML = '<i class="fa-brands fa-cc-diners-club"></i>' || 'invalid';
            } 
        }
        function fieldStatus(input, valid){
            if(valid){
                removeClass(input.parentNode, 'error');
            } else {
                addClass(input.parentNode, 'error');
            }
            return valid;
        }
        function addClass(ele, _class){
            if(ele.className.indexOf(_class)===-1){
                ele.className += ' '+_class;
            }
        }
        function removeClass(ele, _class){
            if(ele.className.indexOf(_class) != -1){
                ele.className = ele.className.replace(_class, '');
            }
        }
})();