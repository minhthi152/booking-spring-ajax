$(() => {
    $("#formCreateBooking").validate({
        rules: {
            tenantName: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            tenantEmail: {
                required: true,
                email: true,
                maxlength: 50
            },
            tenantPhone: {
                required: true
            }
        },
        messages: {
            tenantName: {
                required: "Please fill in tenant name",
                minlength: jQuery.validator.format("Tenant name has min {0} characters"),
                maxlength: jQuery.validator.format("Tenant name has max {0} characters")
            },
            tenantEmail: {
                required: "Please fill in tenant email",
                email: "Please enter right email format",
                maxlength: jQuery.validator.format("Email has max {0} characters")
            },
            tenantPhone: {
                required: "Please fill in tenant phone"
            }
        },
        errorLabelContainer: "#createBookingModal .modal-alert-danger",
        errorPlacement: function (error, element) {
            error.appendTo("#createBookingModal .modal-alert-danger");
        },
        showErrors: function(errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#createBookingModal .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#createBookingModal .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#formCreateBooking input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        submitHandler: function () {
            handleCreateBooking();
        }
    })
})