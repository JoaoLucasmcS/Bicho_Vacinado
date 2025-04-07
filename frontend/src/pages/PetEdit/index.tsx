import { useParams } from 'react-router-dom';

import * as Yup from "yup";
import { Formik } from "formik";
import { useNavigate } from 'react-router-dom';
import { FaArrowLeft } from "react-icons/fa6";

import { IconSelector } from "@components/IconSelector";
import { PetIconName } from "@/utils/petIcons";
import { PetType } from '@/types/pet';

import { Container, FormButton, FormContainer, FormErrorMessage, FormField, FormLabel, BackButton } from "./styles"

export type FormValues = {
  name: string;
  age: number | null;
  type: PetType;
  description: string;
  icon: PetIconName;
}

type Props = {
  onSubmit: (values: FormValues) => Promise<void>;
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

const PetEdit = ({ onSubmit }: Props) => {
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();

  // TODO Encontrar o pet pelo id e preencher os campos do formulário com os dados do pet
  const initialValues: FormValues = {
    name: '',
    age: null,
    type: 'Gato',
    description: '',
    icon: 'cat1',
  };
  
  const handleSubmit = async (values: FormValues) => {
    try {
      await onSubmit(values);
    } catch (error) {
      console.error("Erro ao adicionar pet:", error);
    }
  };

  return (<>
    <BackButton
      onClick={() => navigate(-1)}
    >
      <FaArrowLeft />
    </BackButton>

    <Container>
      <Formik
        initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={handleSubmit}
        enableReinitialize={true}
      >
        {({ values, setFieldValue, isSubmitting }) => (
          <FormContainer>
            <div className="form-group">
              <FormLabel htmlFor="name">Nome:</FormLabel>
              <FormField type="text" id="name" name="name" placeholder="Informe o nome do seu pet" />
              <FormErrorMessage name="name" component="div" />
            </div>

            <div className="form-group">
              <FormLabel htmlFor="age">Idade:</FormLabel>
              <FormField type="number" id="age" name="age" min="0" max="50" />
              <FormErrorMessage name="age" component="div" />
            </div>

            <div className="form-group">
              <FormLabel htmlFor="type">Tipo:</FormLabel>
              <FormField as="select" id="type" name="type">
                <option value="Gato">Gato</option>
                <option value="Cachorro">Cachorro</option>
              </FormField>
              <FormErrorMessage name="type" component="div" />
            </div>

            <div className="form-group">
              <FormLabel htmlFor="description">Descrição (opcional):</FormLabel>
              <FormField 
                as="textarea" 
                id="description" 
                name="description" 
                rows={3} 
                placeholder="Descreva características do pet" 
              />
              <FormErrorMessage name="description" component="div" />
            </div>

            <div className="form-group">
              <FormLabel>Ícone:</FormLabel>
              <IconSelector 
                type="SECONDARY"
                selectedIcon={values.icon}
                onIconSelect={(icon: PetIconName) => {
                  setFieldValue('icon', icon);
                }}
              />
              <FormErrorMessage name="icon" component="div" />
            </div>

            <FormButton type="submit">
              {isSubmitting ? "Editando..." : "Editar Informações"}
            </FormButton>
          </FormContainer>
        )}
      </Formik>
    </Container>
  </>);
}

export default PetEdit;