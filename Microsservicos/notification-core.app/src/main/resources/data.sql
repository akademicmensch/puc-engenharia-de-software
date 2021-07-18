DROP TABLE IF EXISTS TB_NOTIFICACAO;

CREATE TABLE TB_NOTIFICACAO (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  tipoNotificacao VARCHAR(250) NOT NULL,
  parametrosNotificacao VARCHAR(250) NOT NULL
);

INSERT INTO TB_NOTIFICACAO (tipoNotificacao, parametrosNotificacao) VALUES
  ('lateProject', 'managerEmail'),
  ('lateActivity', 'associateEmail');