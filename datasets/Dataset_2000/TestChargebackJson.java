public class TestChargebackJson extends JaxrsTestSuite {
    private static final ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.registerModule(new JodaModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
    @Test(groups = "fast")
    public void testJson() throws Exception {
        final DateTime requestedDate = new DateTime(DateTimeZone.UTC);
        final DateTime effectiveDate = new DateTime(DateTimeZone.UTC);
        final BigDecimal chargebackAmount = BigDecimal.TEN;
        final String paymentId = UUID.randomUUID().toString();
        final String reason = UUID.randomUUID().toString();
        final List<AuditLogJson> auditLogs = createAuditLogsJson();
        final ChargebackJson chargebackJson = new ChargebackJson(requestedDate, effectiveDate, chargebackAmount, paymentId,
                                                                 reason, auditLogs);
        Assert.assertEquals(chargebackJson.getRequestedDate(), requestedDate);
        Assert.assertEquals(chargebackJson.getEffectiveDate(), effectiveDate);
        Assert.assertEquals(chargebackJson.getChargebackAmount(), chargebackAmount);
        Assert.assertEquals(chargebackJson.getPaymentId(), paymentId);
        Assert.assertEquals(chargebackJson.getReason(), reason);
        Assert.assertEquals(chargebackJson.getAuditLogs(), auditLogs);
        final String asJson = mapper.writeValueAsString(chargebackJson);
        final ChargebackJson fromJson = mapper.readValue(asJson, ChargebackJson.class);
        Assert.assertEquals(fromJson, chargebackJson);
    }
}