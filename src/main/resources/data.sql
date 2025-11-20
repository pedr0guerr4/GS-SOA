INSERT INTO competencias (nome, categoria, descricao) VALUES
('Inteligência Artificial', 'Tecnologia', 'Fundamentos de IA aplicada ao ambiente corporativo'),
('Análise de Dados', 'Tecnologia', 'Coleta, tratamento e visualização de dados para tomada de decisão'),
('Comunicação Empática', 'Habilidades Humanas', 'Comunicação centrada em escuta ativa e empatia'),
('Colaboração em Ambientes Remotos', 'Habilidades Humanas', 'Trabalho em equipe em times distribuídos e híbridos');

INSERT INTO trilhas (nome, descricao, nivel, carga_horaria, foco_principal) VALUES
('Trilha – Fundamentos de Dados e IA', 'Formação introdutória em dados e inteligência artificial para negócios.', 'INICIANTE', 30, 'Data & IA'),
('Trilha – Liderança Colaborativa em Times Remotos', 'Desenvolver liderança, colaboração e comunicação em ambientes híbridos.', 'INTERMEDIARIO', 24, 'Soft Skills & Remote Work');

-- Vincular trilhas às competências
INSERT INTO trilha_competencia (trilha_id, competencia_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4);
