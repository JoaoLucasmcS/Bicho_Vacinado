import { useState } from "react";

import * as Yup from "yup";
import { Formik, Form, Field, ErrorMessage } from "formik";

import { IconSelector } from "@components/IconSelector";

import { PetIconName } from "@/utils/petIcons";

type PetType = "Cachorro" | "Gato";

type FormValues = {
  id: number;
  name: string;
  age: number;
  type: PetType;
  description: string;
  icon: PetIconName;
}

const validationSchema = Yup.object().shape({
  name: Yup.string()
    .min(2, 'Nome muito curto')
    .max(50, 'Nome muito longo')
    .required('Nome é obrigatório'),
  age: Yup.number()
    .min(0, 'Idade não pode ser negativa')
    .max(50, 'Idade muito alta')
    .required('Idade é obrigatória'),
  type: Yup.string()
    .oneOf(['Cachorro', 'Gato'], 'Tipo inválido')
    .required('Tipo é obrigatório'),
  description: Yup.string()
    .max(500, 'Descrição muito longa'),
  icon: Yup.string()
    .required('Ícone é obrigatório')
});

export const FormAddPet = ({ onSubmit }: { onSubmit: (values: FormValues) => void }) => {
  const [nextId, setNextId] = useState(1);

  const initialValues: FormValues = {
    id: nextId,
    name: '',
    age: 0,
    type: 'Gato',
    description: '',
    icon: 'cat1',
  };

  const handleSubmit = (values: FormValues, { resetForm }: { resetForm: () => void }) => {
    onSubmit(values);
    setNextId(prevId => prevId + 1);
    resetForm();
  };

  return (
    <div className="pet-form">
      <h2>Adicionar Novo Pet</h2>
      <Formik
        initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={handleSubmit}
        enableReinitialize={true}
      >
        {({ values, setFieldValue }) => (
          <Form>
            <div className="form-group">
              <label htmlFor="id">ID:</label>
              <Field type="text" id="id" name="id" disabled value={nextId} />
            </div>

            <div className="form-group">
              <label htmlFor="name">Nome:</label>
              <Field type="text" id="name" name="name" placeholder="Digite o nome do pet" />
              <ErrorMessage name="name" component="div" className="error-message" />
            </div>

            <div className="form-group">
              <label htmlFor="age">Idade:</label>
              <Field type="number" id="age" name="age" min="0" max="50" />
              <ErrorMessage name="age" component="div" className="error-message" />
            </div>

            <div className="form-group">
              <label htmlFor="type">Tipo:</label>
              <Field as="select" id="type" name="type">
                <option value="Gato">Gato</option>
                <option value="Cachorro">Cachorro</option>
              </Field>
              <ErrorMessage name="type" component="div" className="error-message" />
            </div>

            <div className="form-group">
              <label htmlFor="description">Descrição (opcional):</label>
              <Field 
                as="textarea" 
                id="description" 
                name="description" 
                rows={3} 
                placeholder="Descreva características do pet" 
              />
              <ErrorMessage name="description" component="div" className="error-message" />
            </div>

            <div className="form-group">
              <label>Ícone:</label>
              <IconSelector 
                selectedIcon={values.icon}
                onIconSelect={(icon: PetIconName) => {
                  setFieldValue('icon', icon);
                }}
              />
              <ErrorMessage name="icon" component="div" className="error-message" />
            </div>

            <button type="submit" className="submit-button">
              Enviar
            </button>
          </Form>
        )}
      </Formik>
    </div>
  )
}